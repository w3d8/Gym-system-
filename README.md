# Gym Management System

## Overview

Gym Management System is a Java-based application developed to simulate the management of a fitness club. The system helps manage gym memberships, member registrations, trainer information, and additional fitness services through a simple menu-driven interface.

The project was developed using Object-Oriented Programming (OOP) principles and demonstrates the practical use of inheritance, abstraction, polymorphism, interfaces, file handling, collections, and exception handling in Java.

---

## System Features

The system provides several services that help manage gym operations, including:

### Subscription Management
- Create and manage gym subscriptions.
- Support for two subscription types:
  - General Subscription
  - VIP Subscription
- Calculate subscription costs based on membership duration.
- Display available subscriptions and their benefits.
- Remove existing subscriptions.

### Registration Management
- Register new gym members.
- Link members to available subscriptions.
- Confirm registrations.
- Cancel existing registrations.
- View registration details using registration ID.

### Trainer Management
- Add trainers to the system.
- Store trainer information such as:
  - Name
  - ID
  - Years of experience
  - Main specialization
  - Professional certificates

### Extra Services
- Calculate daily calorie requirements based on user information.
- Display available meal options and prices.

### Data Storage
- Save trainer information to a text file.
- Read stored trainer information from a text file.

### User Interface
- Console-based menu system.
- Graphical User Interface (GUI) support.

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Inheritance
- Polymorphism
- Abstraction
- Interfaces
- ArrayList Collections
- Exception Handling
- File Handling (I/O)
- Java GUI

---

## Project Structure

### Person (Abstract Class)

Base class for all people in the system.

Attributes:
- id
- name

Extended by:
- Member
- Trainer

---

### Subscription (Abstract Class)

Base class for all subscription types.

Attributes:
- id
- name
- pricePerMonth
- TimeInMonth

Extended by:
- General
- VIP

---

### General

Represents a standard gym membership.

Features:
- Limited gym access.
- Friend invitation functionality.
- Subscription price calculation.

---

### VIP

Represents a premium gym membership.

Features:
- Includes a personal trainer.
- Additional VIP benefits.
- Free parking service.
- Enhanced subscription package.

---

### Member

Represents gym members.

Stores:
- Member ID
- Name
- Phone number

---

### Trainer

Represents trainers within the gym.

Stores:
- Trainer ID
- Name
- Experience
- Specialization
- Certifications

---

### Certificate

Represents professional certificates earned by a trainer.

Stores:
- Certificate name
- Certificate year

---

### Registration

Handles member registrations.

Responsibilities:
- Create registrations.
- Confirm registrations.
- Cancel registrations.
- Track registration status.

---

### ExtraService

Provides additional fitness-related services.

Features:
- Calorie calculation.
- Additional membership services.

---

### MEALS

Represents available meal options.

Stores:
- Meal name
- Meal price

---

### Payable Interface

Implemented by:
- Registration
- ExtraService

Responsibilities:
- Define payment-related behavior.
- Provide VAT constant.

---

### ReadText

Handles reading information from text files.

Responsibilities:
- Open text files.
- Read and display file contents.
- Handle file-related exceptions.

---

### WriteText

Handles writing information to text files.

Responsibilities:
- Save trainer data.
- Store information for future use.

---

### Main

The entry point of the application.

Responsibilities:
- Display system menu.
- Handle user input.
- Manage system operations.
- Connect all classes together.

---

## How to Run the Project

### 1. Download the Project

Download the project files.
```
Gym-Management-System
│
├── src
│   └── projectgymsystem
│       ├── Main.java
│       ├── GymSystem.java
│       ├── Member.java
│       └── Other Classes...
│
├── nbproject
├── build.xml
├── manifest.mf
└──  README.md
```

### 2. Open the Project

Open the project folder using:

- NetBeans (Recommended)
- IntelliJ IDEA
- Eclipse

### 3. Run the Application

Locate the following file:

src/projectgymsystem/Main.java

Run the file and the system menu will appear.

### 4. Use the System

The main menu provides the following options:

1. Add Subscription
2. Display Subscription
3. Remove Subscription
4. New Registration
5. Show Registration
6. Cancel Registration
7. Join as Trainer
8. Extra Services
9. Save Trainers
 10. Read Trainers
 11. GUI
 12. Exit

---

## OOP Concepts Demonstrated

This project demonstrates:

- Encapsulation
- Inheritance
- Abstraction
- Polymorphism
- Interfaces
- Composition
- Exception Handling
- File Processing

---

## Future Improvements

Possible future enhancements include:

- Database integration.
- Online payment support.
- Attendance tracking system.
- Membership renewal reminders.
- Enhanced graphical interface.
- Trainer scheduling system.

---

## Conclusion

Gym Management System provides a complete simulation of a gym management environment while demonstrating core Java programming concepts and software engineering practices. The project combines membership management, trainer administration, registration processing, file handling, and fitness-related services within a single application.
