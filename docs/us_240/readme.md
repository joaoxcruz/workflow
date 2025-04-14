# US 240 Drone model creation

## 1. Context

This User Story (US240) is being developed for the first time. The goal is to provide Drone Technicians the capability to define and register new types (models) of drones within the Shodrone system. This is a foundational requirement for managing the drone fleet, as specific drone instances will belong to these defined models. The requirement includes support for both manual creation via a user interface and automated creation through a bootstrap process.

### 1.1 List of issues

Analysis: #130,#131

Design: #132,#133

Implement: #134,#135

Test: #136


## 2. Requirements

**US 240** As a Drone Tech, I want to create a drone model in the system, so that I can define new types of drones.

**Description:**

This user story describes the requirement for Drone Techs to be able to define new drone models within the system. This will involve specifying the characteristics and capabilities of different drone types. The story also mentions that this should be achievable through a bootstrap process.

**Acceptance Criteria:**

*   **US240.1:** Given a Drone Tech with appropriate permissions, when they provide the specifications for a new drone model (e.g., name, capabilities, physical attributes), then the system should create a new drone model record in the system.
*   **US240.2:** The system should prevent the creation of drone models with duplicate names (case-insensitive).
*   **US240.3:** The system should store the provided specifications accurately for the created drone model.
*   **US240.4:** The system should support the creation of drone models via a bootstrap process (e.g., configuration files or initial data loading).

**Dependencies/References:**

*   **User Roles & Permissions:** The Drone Tech role must have the necessary permissions to execute this functionality.
*   **Bootstrap Mechanism:** A general bootstrap or initial data loading mechanism might need to be established if not already present.

## 3. Analysis

This user story focuses on introducing the concept of a `DroneModel` into the system. Based on the existing Domain Model (`docs/us_110/DomainModel.puml`), the `DroneModel` entity already exists within the `Drone Aggregate`. It serves as the blueprint for individual `Drone` instances.

Key elements involved:
*   **DroneModel (ER):** The central entity representing a type of drone. It will encapsulate attributes like `ModelName`, and likely value objects representing `Capabilities` and `PhysicalAttributes`.
*   **Drone Aggregate:** The context within which `DroneModel` exists. It appears `DroneModel` might be an Aggregate Root itself, or closely related to the `Drone` entity within a larger aggregate boundary (needs clarification, but we'll treat `DroneModel` as the focus here).

The bootstrap requirement implies that model definitions might be loaded from a configuration source (e.g., YAML, properties file, database script) during application startup or initial setup.

![Use Case Diagram](analysis/use_case_diagram_240.svg)
![Domain Model](analysis/domain_model_240.svg)
![System Sequence Diagram](analysis/system_sequence_diagram_240.svg)

## 4. Design

The design follows a standard layered architecture approach.

### 4.1. Realization

A UI component will allow the Drone Tech to input model details. A controller will handle the request, delegating the core logic to an application service. The service will validate the input, create the `DroneModel` domain entity, and use a repository to persist it.

For the bootstrap process, a dedicated service or component will read data from a predefined source (e.g., a configuration file) and use the same application service or repository layer to create the `DroneModel` entities during system initialization.

![Class Diagram](design/class_diagram_240.svg)
![Sequence Diagram](design/sequence_diagram_240.svg)

### 4.3. Applied Patterns

*   **Domain-Driven Design (DDD):** Use of Entities (`DroneModel`), Value Objects (e.g., `ModelName`, `ModelCapabilities`), Aggregate (implicitly around `DroneModel`), and Repositories.
*   **Repository Pattern:** Abstracting data persistence logic for `DroneModel`.
*   **DTO (Data Transfer Object):** To pass data between the UI/API layer and the application service layer.
*   **Layered Architecture:** Separating Presentation (UI), Application, Domain, and Infrastructure concerns.

### 4.4. Acceptance Tests

**Test 1: Create Valid Drone Model via UI**
*   **Given:** A logged-in Drone Tech.
*   **When:** They navigate to the "Create Drone Model" UI and enter valid, unique data (Name: "DJI Phantom 5", Capabilities: "4K Camera, 30min flight", Attributes: "Weight: 1.5kg").
*   **Then:** The system successfully creates the `DroneModel` record, and a confirmation message is shown.
*   **Refers to Acceptance Criteria:** US240.1, US240.3

## 5. Implementation

*   **Domain Layer:** Implement the `DroneModel` entity and associated Value Objects (`ModelName`, `ModelCapabilities`, `PhysicalAttributes`). Ensure validation logic (e.g., non-empty name) is within the domain objects.
*   **Application Layer:** Implement `DroneModelApplicationService` with the `createDroneModel` method containing orchestration logic (validation checks, interaction with repository).
*   **Infrastructure Layer:** Implement `DroneModelRepository` (e.g., `JpaDroneModelRepository`) for database interaction.
*   **Presentation Layer:** Implement `CreateDroneModelUI` and `CreateDroneModelController` to handle user interaction.

## 6. Integration/Demonstration

*   **Integration:** This functionality is foundational. Once implemented, the created drone models should appear in dropdowns or selection lists in UIs related to adding individual drones (US330) or configuring show proposals (US311, US312).
*   **Demonstration:**
    1.  Show the "Create Drone Model" UI. Enter details for a new model and successfully save it.
    2.  Attempt to create a model with the same name (case-insensitive) and show the error message.
    3.  Restart the application (or trigger the bootstrap process) and verify through the UI or database query that models defined in the bootstrap configuration have been created.

## 7. Observations


```