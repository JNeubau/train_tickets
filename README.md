# Train Tickets
A Camunda + Spring project describing a process of buying a train ticket.

# Process of buying a train ticket

1. **Form Submission**: Process start with form asking about the basic information regarding train.
2. **Choose your ticket type:**
    - **One-way:** A ticket for a single journey.
    - **Round-trip:** A ticket for a journey to a destination and back.
2. **Train Selection**:  Client (initiator) is asked to select from available trains.
3. **Personal Information**: Client is asked to enter personal info, select discount (if applies), type of prefered seat and class.
4. **Seat Availability Check**: The system checks if on the train is prefered seat available. 
    - If yes it is reserved. 
    - If not, random seat is selected and reserved. 
7. **Review and confirm your booking:**: Double-check details and confirm.
5. **Payment Method**: Client is asked about payment method and details.
    - If payment is successful the ticket is issued.
    - If payment is unsuccessful, the client have to enter payment info again.
8. **Payment Attempts**: On third unsuccessful payment, reservation is cancelled and the client have to go to ticket office.