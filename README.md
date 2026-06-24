# MotoPart Backend (Spring Boot + PostgreSQL)

Rebuilt backend for the MotoPart Flutter app, reproducing the original cloud API
contract (all 26 endpoints, exact JSON shapes, and the `{ "Response": { "Status", "Data" } }`
envelope). The original base path `/motopart/public` is preserved via the server
context-path, so the app's existing base URL keeps working when you point it at this server.

## Requirements
- JDK 21
- PostgreSQL 14+
- Maven (or use IntelliJ's bundled Maven)

## 1. Create the database
```bash
psql -U postgres -c "CREATE USER motopart WITH PASSWORD 'motopart';"
psql -U postgres -c "CREATE DATABASE motopart OWNER motopart;"
```
(Or edit credentials in `src/main/resources/application.properties`.)

## 2. Run
```bash
mvn spring-boot:run
```
Flyway creates all tables (V1) and inserts sample rows (V2) on first start.

The API is served at:  `http://localhost:8080/motopart/public/...`
e.g. `GET http://localhost:8080/motopart/public/type`

## 3. Point the Flutter app here
In `cloud_api_client.dart` set:
```dart
static const String _BASE_URL = "http://10.0.2.2:8080/motopart/public/";
```
(`10.0.2.2` is the Android emulator's alias for your Mac's localhost. For a real
device use your Mac's LAN IP.)

## Auth
- **Admin writes** (`POST /year|/makers|/model|/parts|/subpart|/customad|/adminpost`,
  `PUT /cleardata/1`) require header `token` matching `app.admin.token` in properties.
  The default value is the same token the original app sent.
- **Post creation** (`POST /post`) reads the `userId` header to attribute the listing.

## Notes / assumptions
- The misspelled fields `item_tittle` and the `suggession` endpoint are kept
  intentionally for client compatibility.
- OTP is generated and stored; for local testing the generated code is returned in
  the response message. Wire it to an SMS provider and stop returning it before production.
- The image upload endpoint stores files under `./uploads` and returns
  `{ "url": ... }` (unwrapped), matching the original. Serve that folder via a static
  handler or object storage in production.
- The `cleardata` payload shape wasn't present in the Flutter cloud layer, so its
  controller accepts an open JSON body — fill in the clearing logic once confirmed.

## Endpoint map
See `requests.http` for a ready-to-run example of every endpoint (IntelliJ HTTP client).
