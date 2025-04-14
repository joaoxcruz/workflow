# US 230 Register Show request

## 1. Context

This is the first time the task is assigned to be developed. The primary goal of this User Story is to implement the functionality allowing a CRM Collaborator to register a new show request made by a customer. This involves capturing various details about the requested show and persisting this information in the system.

### 1.1 List of issues

*   **Analysis:** #38 , #39
*   **Design:** #40 , #41
*   **Implementation:** #42 , #43 , #44 , #45
*   **Testing:** #46


## 2. Requirements

**US 230** As a CRM Collaborator, I want to register a show request.

**Acceptance Criteria:**

* Given that I am logged in as a CRM Collaborator,
    When I access the section for show requests,
    Then I should have the option to register a new show request.

* Given the option to register a new show request,
    When I provide the necessary information (e.g., requesting customer, requested show type, date/time preference, any specific requirements),
    Then the system should save this information as a new show request record.

* Given a successfully registered show request,
    Then the system should provide a confirmation message or indication.

* Given a registered show request,
    Then the system should associate it with the requesting customer.

* Given the need to manage show requests,
    Then the system should allow for the viewing of registered show requests, potentially with details of the request.

* Given different types of shows might be offered,
    Then the registration process should allow for the selection of the specific type of show being requested.

**Dependencies/References:**

*   This user story depends on the existence of customers in the system (US220 Register customer).
*   The show description might reference figures from the catalogue (related to US231 Figure catalogue, US232 Search Figure catalogue) 

## 3. Analysis

![Use Case Diagram](analysis/use-case-diagram-230.svg)
![Domain Model](analysis/domain-model-230.svg)
![System Sequence Diagram](analysis/system-sequence-diagram-230.svg)

## 4. Design

### 4.1. Realization 

![Sequence diagram](design/sequence-diagram-230.svg)

### 4.2. Class Diagram

![Class diagram](design/class-diagram-230.svg)

### 4.3. Applied Patterns

*   **Controller:** Separates UI logic from application/domain logic (`RegisterShowRequestController`).
*   **Repository:** Abstracts data persistence (`CustomerRepository`, `ShowRequestRepository`).
*   **Factory/Builder (implied):** The `ShowRequest` creation logic is encapsulated within its constructor, acting like a simple factory.
*   **Value Object:** Used for attributes like `VAT`, `Place_1`, `Date_3`, `Duration_2`, `DronesRequested`, `Description_1`, `ShowRequestStatus`, `Status`.
*   **Entity:** `ShowRequest`.
*   **Aggregate Root:** `Customer`.

### 4.4 Acceptance Tests

## 5. Implementation

## 6. Integration/Demonstration

## 7. Observations