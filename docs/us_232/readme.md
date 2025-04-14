# US 232 Search Figure catalogue

## 1. Context

This User Story (US232) is being developed for the first time during Sprint 2. It aims to enhance the usability of the figure catalogue by providing CRM Collaborators with search capabilities based on categories and keywords. This complements US231 (List Public Figures) by offering a more targeted way to find specific figures.
### 1.1 List of issues

Analysis:

Design:

Implement:

Test:


## 2. Requirements


*Example*

**US 232** As CRM Collaborator, I want to search the figure catalogue by category and/or keyword, so that I can easily find figures I'm looking for.
**Acceptance Criteria:**

*   **US232.1:** Given the figure catalogue, when a CRM Collaborator enters only a `Category` to search by, then the system should display **active, public** figures belonging to that exact category.
*   **US232.2:** Given the figure catalogue, when a CRM Collaborator enters only a `KeyWord` to search by, then the system should display **active, public** figures associated with that keyword (case-insensitive, accent-insensitive match).
*   **US232.3:** Given the figure catalogue, when a CRM Collaborator enters both a `Category` and a `KeyWord` to search by, then the system should display **active, public** figures that belong to the exact category **AND** are associated with the keyword (case-insensitive, accent-insensitive match).
*   **US232.4:** If no category or keyword is provided, the system should ideally return an empty list or indicate that search criteria are needed (behavior to be confirmed, default to empty list for now).
*   **US232.5:** If no figures match the given criteria, the system should display an empty list or an appropriate "no results found" message.
*   **US232.6:** The search functionality should be responsive and provide results in a reasonable time (Non-Functional Requirement).
*   **US232.7:** The search should ignore accents and shouldn't be case sensitive (as specified on page 14 of the project description for this US).

**Dependencies/References:**

*   **US233 (Add Figure):** Figures need to be added with categories and keywords.
*   **US234 (Decommission Figure):** Logic for filtering out decommissioned figures is required.
*   **US245/US247 (Categories):** Management and listing of categories used for searching.
*   **US231 (List Public Figures):** Provides the baseline catalogue content this US searches within.
## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization

![a class diagram](class-diagram-01.svg "A Class Diagram")

### 4.3. Applied Patterns

### 4.4. Acceptance Tests

Include here the main tests used to validate the functionality. Focus on how they relate to the acceptance criteria. May be automated or manual tests.

**Test 1:** *Verifies that it is not possible to ...*

**Refers to Acceptance Criteria:** US101.1


```
@Test(expected = IllegalArgumentException.class)
public void ensureXxxxYyyy() {
	...
}
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*