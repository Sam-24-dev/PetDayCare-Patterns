package ec.edu.espol.petdaycare.patterns.Facade;

import ec.edu.espol.petdaycare.patterns.Composite.ServiceComponent;

public class BookingFacade {
    private SpaceManager spaceManager;
    private StaffManager staffManager;
    private PolicyValidator policyValidator;
    private ReservationRepository reservationRepository;
    private NotificationService notificationService;

    public BookingFacade(SpaceManager spaceManager, StaffManager staffManager,
                         PolicyValidator policyValidator, ReservationRepository reservationRepository,
                         NotificationService notificationService) {
        this.spaceManager = spaceManager;
        this.staffManager = staffManager;
        this.policyValidator = policyValidator;
        this.reservationRepository = reservationRepository;
        this.notificationService = notificationService;
    }

    public String bookService(String petName, ServiceComponent service, String date) {
        if (petName == null || service == null || date == null) {
            throw new IllegalArgumentException("Datos de reserva incompletos");
        }

        if (!service.checkAvailability()) {
            return "Servicio no disponible";
        }

        if (!policyValidator.validate(petName, service)) {
            return "Política rechazada";
        }

        if (!spaceManager.hasSpace(date) || !staffManager.hasStaffAvailable(date)) {
            return "No hay cupos disponibles";
        }

        int bookingId = reservationRepository.saveReservation(petName, service, date);
        notificationService.notifyBookingConfirmation(petName, bookingId);

        return "Reserva confirmada";
    }

    public String cancelBooking(int bookingId) {
        if (reservationRepository.exists(bookingId)) {
            reservationRepository.delete(bookingId);
            notificationService.notifyCancellation(bookingId);
            return "Reserva cancelada";
        }
        return "Reserva no encontrada";
    }
}
