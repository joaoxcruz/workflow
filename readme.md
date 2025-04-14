# Project Shodrone

## 1. Description of the Project

The back-office system for **Shodrone** supports the full workflow of organizing customized drone shows. It manages operations from client interaction to show design, simulation, and validation.

### Main Features
 
1. **Client Management**  
   The system registers and manages corporate and public sector clients across the European market.

2. **Show Requests & Proposals**  
   Clients submit requests for drone shows. The system handles the creation of detailed proposals, which include sequences of drone formations ("figures"). Some figures are exclusive to specific clients for a limited time.

3. **Figure Library**  
   A central library stores reusable drone formations, described in **Domain Specific Language (DSL)**. The system supports adding new figures (standard or client-specific) and version control.

4. **Drone Fleet Management**  
   The system manages the entire drone inventory. It allows for defining drone models, adding/removing individual drones, and configuring each model with its supported programming language.

5. **Simulation & Testing**  
   A robust simulation validates both individual figures and full shows. It:
   - Converts DSL descriptions into drone-specific code via plugins.
   - Simulates hundreds of drones flying in a 3D space simultaneously, detecting collisions between drones.
   - Coordinates drone actions through an orchestrator server.
   - Generates detailed simulation reports covering execution, collisions, and success/failure.

6. **User & Role Management**  
   System users are authenticated by `@showdrone.com` email addresses. Roles include Admin, CRM Manager, CRM Collaborator, Show Designer, and Drone Technician, each with specific access rights.

7. **Customer Interaction**  
   Clients use a dedicated interface to check their show schedule, view proposals, and approve or reject them directly.


## 2. Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Build

*To Do*

## 4. How to Execute Tests

*To Do*

## 5. How to Run

*To Do*

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

*To Do*

## 7. How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

    ./generate-plantuml-diagrams.sh


