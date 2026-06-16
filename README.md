# Gym Management System

A Java-based gym management system that handles subscriptions, registrations, trainers, and extra services.

## Overview

This system is designed to manage a gym's daily operations including:
- Managing member subscriptions (General and VIP)
- Processing registrations
- Handling trainer information
- Providing extra services like meal plans and calorie calculations
- File I/O operations for data persistence

## Project Structure

### Core Classes

#### Person (Abstract Class)
- Base class for all persons in the system
- Contains common attributes: `id`, `name`
- Extended by `Member` and `Trainer`

#### Subscription (Abstract Class)
- Base class for subscription types
- Attributes: `name`, `id`, `pricePerMonth`, `TimeInMonth`
- Abstract method: `calcPrice()`
- Extended by `General` and `VIP`

#### General
- Standard gym subscription
- Adds `MAX_ACCESS` (maximum gym visits)
- Calculates price: `pricePerMonth + 100 SAR` × duration

#### VIP
- Premium subscription with personal trainer
- Includes `Trainer` object
- Calculates price: `pricePerMonth + 460 SAR` × duration

#### Trainer
- Extends `Person`
- Attributes: `experience`, `mainSpecialization`, `Certificate[]`
- Stores trainer's qualifications and certifications

#### Certificate
- Represents a trainer's certification
- Attributes: `name`, `year`

#### Registration
- Implements `Payable` interface
- Links a member with a subscription
- Tracks registration status: "New", "CONFIRMED", "CANCELLED"
- Static counter for registration numbers

#### ExtraService
- Implements `Payable` interface
- Provides calorie calculation based on weight and height
- Supports meal ordering functionality

#### MEALS
- Represents meal options
- Attributes: `mealName`, `price`

### Interfaces

#### Payable
- Contains constant `VAT` (0.75)
- Defines abstract method `pay()`
- Implemented by `Registration` and `ExtraService`

### File I/O

#### WriteText
- Writes subscription data to text file using `Formatter`
- Uses `Subscription.toString()` for formatting

#### ReadText
- Reads data from text file using `Scanner`
- Handles `FileNotFoundException` and `NoSuchElementException`

### Main System

#### GymSystem
- Main application class with menu-driven interface
- Uses `ArrayList` for storing subscriptions, registrations, and trainers
- Provides 11 main functions:
  1. Add Subscription
  2. Remove Subscription
  3. New Registration
  4. Show Registration
  5. Cancel Registration
  6. Join as Trainer
  7. Extra Services (Calories/Meals)
  8. Save to File
  9. Read from File
  10. GUI (placeholder)
  11. Exit

## Features

### Subscription Management
- Add General or VIP subscriptions
- Remove existing subscriptions
- Calculate total price based on duration

### Registration System
- Register members with existing subscriptions
- Confirm or cancel registrations
- View registration information

### Trainer Management
- Store trainer details including experience and certifications
- VIP subscriptions include personal trainer

### Extra Services
- Calculate daily calorie needs based on weight and height
- Order meals with displayed prices

### Data Persistence
- Save subscription data to text file
- Read data from text file

## Technical Notes

- Uses Java's abstract classes and interfaces
- Implements polymorphism with `Subscription` and `Person`
- Exception handling with try-catch blocks
- Static members for registration count
- Array-based certificate storage for trainers



