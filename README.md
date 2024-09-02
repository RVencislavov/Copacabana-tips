# Copacabana-Tips Employee Portal

Welcome to the **Copacabana-Tips Employee Portal**! This application is designed to help employees manage contacts effectively, track subscription statuses, and maintain an organized contact list.

## Features

- **Add Contacts:** Easily add new contacts to the portal.
- **Subscription Management:** Check and monitor the subscription status of each contact.
- **Soft Delete Contacts:** Soft delete contacts whose subscriptions have expired or haven't paid.

## Getting Started

Follow these instructions to set up the application and start managing your contacts.

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/) must be installed on your machine.
- A strong password for SQL Server setup.

### Setting Up the Database Container

To set up the SQL Server database container, run the following command in your terminal:

```bash
docker run -e "ACCEPT_EULA=Y" \
  -e "SA_PASSWORD=<YourStrongPasswordHere>" \
  -p 1433:1433 \
  --name craps_db_container \
  -v mydbdata:/var/opt/mssql \
  -d mcr.microsoft.com/mssql/server:2022-latest
