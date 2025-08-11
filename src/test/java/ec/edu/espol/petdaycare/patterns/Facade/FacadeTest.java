package ec.edu.espol.petdaycare.patterns.Facade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.espol.petdaycare.patterns.Composite.DailyPackage;
import ec.edu.espol.petdaycare.patterns.Composite.ServiceComponent;
import ec.edu.espol.petdaycare.patterns.Composite.SimpleService;

/*
  Estas pruebas usan implementaciones "stub" muy simples para los subsistemas:
  - SpaceManagerStub
  - StaffManagerStub
  - PolicyValidatorStub
  - InMemoryReservationRepository (usa la clase real si existe)
  - NotificationServiceStub
*/

public class FacadeTest {

    private BookingFacade facade;
    private SimpleService availableService;
    private SimpleService unavailableService;

    @BeforeEach
    void setup() {
        // Stubs para controlar comportamiento en pruebas
        SpaceManager spaceYes = new SpaceManagerStub(true);
        StaffManager staffYes = new StaffManagerStub(true);
        PolicyValidator policyAccept = new PolicyValidatorStub(true);
        ReservationRepository repo = new InMemoryReservationRepository();
        NotificationService notifier = new NotificationServiceStub();

        facade = new BookingFacade(spaceYes, staffYes, policyAccept, repo, notifier);

        availableService = new SimpleService("Baño", 20.0, 30, true);
        unavailableService = new SimpleService("Paseo", 10.0, 20, false);
    }

    // ---------- PRUEBAS NORMALES ----------

    @Test
    void testBookServiceSuccess() {
        String res = facade.bookService("Luna", availableService, "2025-08-15");
        assertEquals("Reserva confirmada", res);
    }

    @Test
    void testBookServiceWithPackageSuccess() {
        DailyPackage pack = new DailyPackage("Pack");
        pack.add(availableService);
        pack.add(new SimpleService("Extra", 5.0, 10, true));
        String res = facade.bookService("Toby", pack, "2025-08-20");
        assertEquals("Reserva confirmada", res);
    }

    @Test
    void testCancelBookingSuccess() {
        // Primero reservamos para obtener un id; la implementación InMemoryReservationRepository devuelve 1,2,...
        String r = facade.bookService("Max", availableService, "2025-09-01");
        assertEquals("Reserva confirmada", r);

        // Cancelamos id 1
        String cancelRes = facade.cancelBooking(1);
        assertEquals("Reserva cancelada", cancelRes);
    }

    @Test
    void testBookServiceUnavailableService() {
        String res = facade.bookService("Nina", unavailableService, "2025-10-01");
        assertEquals("Servicio no disponible", res);
    }

    @Test
    void testBookServicePolicyRejected() {
        // Facade with policy that rejects
        BookingFacade f2 = new BookingFacade(
                new SpaceManagerStub(true),
                new StaffManagerStub(true),
                new PolicyValidatorStub(false), // rejects
                new InMemoryReservationRepository(),
                new NotificationServiceStub()
        );
        String result = f2.bookService("Bobby", availableService, "2025-08-20");
        assertEquals("Política rechazada", result);
    }

    @Test
    void testBookServiceNoSpaceOrStaff() {
        BookingFacade fSpaceNo = new BookingFacade(
                new SpaceManagerStub(false), // no space
                new StaffManagerStub(true),
                new PolicyValidatorStub(true),
                new InMemoryReservationRepository(),
                new NotificationServiceStub()
        );
        assertEquals("No hay cupos disponibles", fSpaceNo.bookService("Luna", availableService, "2025-11-01"));

        BookingFacade fStaffNo = new BookingFacade(
                new SpaceManagerStub(true),
                new StaffManagerStub(false), // no staff
                new PolicyValidatorStub(true),
                new InMemoryReservationRepository(),
                new NotificationServiceStub()
        );
        assertEquals("No hay cupos disponibles", fStaffNo.bookService("Luna", availableService, "2025-11-01"));
    }

    // ---------- PRUEBAS EXCEPCIÓN / VALIDACIONES ----------

    @Test
    void testBookServiceNullPetNameThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                facade.bookService(null, availableService, "2025-08-15"));
    }

    @Test
    void testBookServiceNullServiceThrows() {
        assertThrows(NullPointerException.class, () ->
                facade.bookService("Luna", null, "2025-08-15"));
    }

    @Test
    void testBookServiceNullDateThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                facade.bookService("Luna", availableService, null));
    }

    @Test
    void testCancelBookingNonexistentReturnsNotFound() {
        // No existe la reserva 999
        assertEquals("Reserva no encontrada", facade.cancelBooking(999));
    }

    // -----------------------------
    // Stubs / helpers locales para pruebas
    // -----------------------------

    // SpaceManager stub
    static class SpaceManagerStub extends SpaceManager {
        private boolean hasSpace;
        public SpaceManagerStub(boolean hasSpace) { this.hasSpace = hasSpace; }
        @Override
        public boolean hasSpace(String date) { return hasSpace; }
    }

    // StaffManager stub
    static class StaffManagerStub extends StaffManager {
        private boolean has;
        public StaffManagerStub(boolean has) { this.has = has; }
        @Override
        public boolean hasStaffAvailable(String date) { return has; }
    }

    // PolicyValidator stub
    static class PolicyValidatorStub extends PolicyValidator {
        private boolean ok;
        public PolicyValidatorStub(boolean ok) { this.ok = ok; }
        @Override
        public boolean validate(String petName, ServiceComponent service) { return ok; }
    }

    // Simple in-memory reservation repo (si ya tienes la real, puedes usarla)
    static class InMemoryReservationRepository extends ReservationRepository {
        // si la clase real ya implementa el comportamiento in-memory, no hace falta sobreescribir nada.
        // Pero por seguridad, nos aseguramos de llamar a la implementación base.
    }

    // NotificationService stub
    static class NotificationServiceStub extends NotificationService {
        @Override
        public void notifyBookingConfirmation(String petName, int bookingId) {
            // No hace nada (evita prints en tests), o podríamos registrar si se desea.
        }
        @Override
        public void notifyCancellation(int bookingId) {
            // No hace nada
        }
    }
}
