# Student Wellness Web Portal

# GitHub Link
https://github.com/EaglesNest-01/WellnessManagementPortal_M2

A Java-based desktop application built using Swing and JavaDB (Apache Derby), designed to manage student wellness through appointment booking, counselor management, and feedback submission. This project follows an **Object-Oriented Programming (OOP)** approach and uses the **MVC (Model-View-Controller)** design pattern to ensure clean architecture and maintainability.

## 🧩 Project Structure

```
com/
│
├── database/                 # Handles all database interactions
│   ├── AppointmentDAO.java
│   ├── CounselorDAO.java
│   ├── FeedbackDAO.java
│   ├── DatabaseHelper.java
│   ├── DerbyConnection.java
│   └── DatabaseTableCreator.java
│
├── gui/                      # GUI Forms (Swing-based)
│   ├── AppointmentManagement.java
│   ├── CounselorManagement.java
│   ├── FeedBackSubmission.java
│   ├── AppointmentView.java
│   ├── CounselorView.java
│   ├── FeedbackView.java
│   ├── Main.java
│   ├── Login.java
│   └── Register.java
│
├── controller/              # MVC Controllers
│   ├── AppointmentController.java
│   ├── CounselorController.java
│   └── FeedbackController.java
│
└── model/                   # JavaBeans / POJOs
    ├── Appointment.java
    ├── Counselor.java
    ├── Feedback.java
    └── Admin.java
```

## ⚙️ Key Features

### 🧠 Object-Oriented Design
- Each domain object (`Appointment`, `Counselor`, `Feedback`, `Admin`) encapsulates data and behavior.
- Reusable and extendable classes following inheritance and encapsulation principles.

### 💾 Database Integration
- **JavaDB (Derby)** used for local persistence.
- `DAO` classes (e.g., `AppointmentDAO`) handle all CRUD operations.
- Tables are created via `DatabaseTableCreator`.

### 🧑‍💼 Admin & Counselor Management
- Register/login functionality.
- Add, update, delete counselors using `CounselorManagement` GUI.
- View all counselors using `CounselorView`.

### 📅 Appointment Booking System
- Book, reschedule, cancel, or complete appointments.
- Appointment `Status` is managed using an `enum`.
- Real-time data displayed in `AppointmentView`.

### 📝 Feedback Submission
- Students can rate and comment on sessions.
- Feedback is stored and displayed via `FeedbackView`.

## 🧪 How to Run

1. **Open in NetBeans IDE.**
2. Ensure JavaDB is properly configured.
3. Set DB path in `DerbyConnection.java`:
   ```java
   String dbURL = "jdbc:derby:D:\\CODE\\WellnessManagementPortal_M2\\Database\\WellnessDB;create=true";
   ```
4. Right-click `Main.java` > Run.

## 📸 UI Preview

![UI Screenshot](./images/ui_preview.png)

## 🔧 Technologies Used

- Java SE (Swing GUI)
- JavaDB (Apache Derby)
- JDBC
- MVC Pattern
- NetBeans IDE

## 👤 Contributors
- Jeremy Kahora
- TGThemba Gumede
- Dieter Olivier
- Jason Romario Maracha Bond

## 📚 License

This project is for academic purposes (PRG381) and not licensed for commercial use.

## 🚀 Future Improvements

- Add email notification system for booked appointments.
- Improve UI with custom styling or JavaFX.
- Add report generation (PDF or Excel).


