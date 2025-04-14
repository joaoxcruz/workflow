# Domain Model Acceptance Tests

This document demonstrates how the current domain model supports key user stories from the project requirements. Each subsection maps a user story to the relevant aggregates, entities, value objects, and relationships within the domain model.

---

## US230 Show request

**US230** – As a CRM Collaborator, I want to register a show request.

### Domain Model Support:

- **Aggregate Involved**: `Client`, `ShowRequest`
- **Key Entities**: `Client`, `ShowRequest`

### Mapping:

A `Client` entity may request one or more `ShowRequest` instances, providing details such as the place, date, number of drones, duration and description.

- `Client "1" --> "1..*" ShowRequest : requests >`
- Each `ShowRequest` specifies:
    - Place (`Place_1` with `Geolocation_1`)
    - Date (`Date_3`)
    - Duration (`Duration_2`)
    - Drones needed (`DronesRequested`)
    - Description (`Description_1`)

### Explanation

When a CRM Collaborator initiates a show request, the domain model handles it by first retrieving or creating 
a `Client` aggregate. The `Client` then invokes a method to register a `ShowRequest`, encapsulating all 
necessary information (place, date, duration, etc.). This `ShowRequest` is validated by domain rules before being persisted. 
The aggregate ensures consistency and enforces business constraints.

## US231 Figure catalogue

**US231** – As CRM Collaborator, I want to list all public figures in the catalogue so that I can select them during a
show request proposal.


### Domain Model Support:

- **Aggregate Involved**: `Client`, `ShowRequest`, `Figure`
- **Key Entities**: `Client`, `ShowRequest`, `Figure`

### Mapping:

The system maintains a centralized `Catalogue` containing all public `Figure` entities. When preparing a `ShowRequest`, a CRM Collaborator can browse this catalogue and associate one or more figures with the request.

- `Catalogue "1" o--> "1..*" Figure : contains >`
- `ShowRequest "1" --> "1..*" Figure : includes >`

Each `Figure` is defined by:
- A version (`Version`)
- A textual description (`Description_3`)
- A category (`Category`)
- A Type (`Type`)
- A Routine (`Routine`)
- A Keyword (`KeyWord`)

### Explanation

When a CRM Collaborator prepares a new `ShowRequest`, they may want to include specific drone figures from the public catalogue. The domain model allows querying the `FigureCatalogue` aggregate to retrieve all available `Figure` instances. The collaborator can then associate selected figures with the `ShowRequest` being created. This design ensures a clean separation between the definition of figures and their use in individual show requests. It also allows reusability and consistency across different requests.

---

## US311 Add drones to a proposal

**US311** – As a CRM Collaborator, I want to configure the list of drones (number and model) of a show proposal.

### Domain Model Support:

- **Aggregates Involved**: `Drone`, `ShowProposal`
- **Key Entities**: `Drone`, `ShowProposal`

### Mapping:

A `ShowProposal` includes a list of drones, each defined by its `Model` and quantity.

- `ShowProposal "1" --> "1..*" Drone : includes >`
- Each `Drone` has:
  - A Serial Number `SerialNumber`
  - A Drone Model `Model` 
  - A status `DroneStatus`
  - Maintenance `Maintenance`

The association between the proposal and the drones ensures the system understands the resources needed to execute the proposal.

### Explanation

When a CRM Collaborator configures a `ShowProposal`, they specify the list of drone models and quantities that will be required for the performance. In the domain model, this is handled by linking each `ShowProposal` to one or more `Drone` entities. Each drone entry encapsulates their information. The aggregate enforces rules such as availability, compatibility, or model constraints. This design supports flexible configuration of shows while maintaining control over drone resource allocation.

---

The model ensures the request includes all necessary information to proceed with show planning.


## Summary

| User Story | Aggregates                  | Main Entities               | Key Support Notes                                                                                                                                                                 |
|------------|-----------------------------|-----------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| US230      | Client, ShowRequest         | Client, ShowRequest         | Client may register a ShowRequest                                                                                                                                                 |
| US231      | Client, ShowRequest, Figure | Client, ShowRequest, Figure | Client needs to list all public figures available in order to select them during a show request proposal.                                                                         |
| US311      | Drone, ShowProposal         | Drone, ShowProposal         | The drones in the proposal must be compaƟble with the drones in the Shodrone’s inventory. There is no need to verify if these drones are used in another show on the same date.   |


---

## Conclusion

The current domain model effectively supports key user stories by clearly separating responsibilities into aggregates and linking them through well-defined relationships. This alignment ensures that future development aligns with the business needs captured in the original requirements.

