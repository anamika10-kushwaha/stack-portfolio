# PortfolioPro — Stock Trading & Portfolio Management

PortfolioPro is a full-stack academic paper-trading application. It lets users create an account, explore sample market data, place simulated trades, and monitor a virtual investment portfolio. It does **not** connect to a brokerage or place real orders.

## Technology stack

- **Frontend:** Angular 20, TypeScript, HTML, CSS
- **Backend:** Java 21, Spring Boot 3.5, Spring Security, JWT
- **Database:** MySQL 8.4, Spring Data JPA / Hibernate
- **Local database option:** Docker Compose

## Features

- User registration and login with JWT authentication
- ₹1,00,000 starting virtual cash for each new user
- Seeded Indian-market sample stocks and stock search
- Simulated BUY and SELL trades
- Holdings and average-cost calculation
- Portfolio value, profit/loss, and transaction history
- Watchlist-ready database model
- Analysis dashboard scaffold
- Responsive dark finance dashboard

## Prerequisites

Install the following before running the project:

- Java Development Kit (JDK) 21
- Apache Maven 3.9 or later
- Node.js (an active LTS release) and npm
- Docker Desktop (recommended for the included MySQL setup), or a local MySQL 8.4 server

Check the installations:

```bash
java -version
mvn -version
node -version
npm -version
```

## Run locally

### 1. Start MySQL with Docker Compose

Run this command from the project root:

```bash
docker compose up -d
```

The Compose file creates a local development database named `portfoliopro`. Its default database credentials are for local development only. Set `MYSQL_USER`, `MYSQL_PASSWORD`, and `MYSQL_ROOT_PASSWORD` in your environment before starting Compose if you want different credentials. Keep real credentials out of Git.

If you use a separately installed MySQL server, create a database named `portfoliopro` and set `DB_URL`, `DB_USER`, and `DB_PASSWORD` for the backend.

### 2. Configure the backend JWT secret

The backend requires a JWT signing secret from the environment. Use a long, random value (at least 32 bytes). Do not commit your actual secret.

**Windows Command Prompt:**

```cmd
set JWT_SECRET=replace-this-with-a-long-random-secret-value
```

**macOS / Linux:**

```bash
export JWT_SECRET='replace-this-with-a-long-random-secret-value'
```

These commands set the variable for the current terminal session. Set it again in a new terminal session.

### 3. Start the backend

Open a terminal at the project root and run:

```bash
cd backend
mvn spring-boot:run
```

The API starts at `http://localhost:8080`. Keep the terminal open.

### 4. Start the frontend

Open a second terminal at the project root and run:

```bash
cd frontend
npm install
npm start
```

Open `http://localhost:4200` in your browser. The frontend currently calls the backend at `http://localhost:8080/api`.

## Windows helper scripts

From the project root, you can also use:

- `start-backend.bat` — starts the Spring Boot backend (set `JWT_SECRET` in that terminal first).
- `start-frontend.bat` — installs frontend dependencies and starts Angular.

The `.sh` scripts provide equivalent commands for macOS/Linux.

## Project structure

```text
PortfolioPro/
├── backend/       # Spring Boot REST API
├── database/      # Database schema notes
├── frontend/      # Angular application
├── .gitignore
├── docker-compose.yml
├── README.md
└── start-*.bat / start-*.sh
```

## Configuration

The backend reads these environment variables when supplied:

| Variable | Purpose |
|---|---|
| `DB_URL` | JDBC connection URL |
| `DB_USER` | Database username |
| `DB_PASSWORD` | Database password |
| `JWT_SECRET` | JWT signing secret (required) |
| `CORS_ORIGIN` | Allowed frontend origin (defaults to `http://localhost:4200`) |

Do not commit `.env` files, passwords, production credentials, private keys, or real user data. The root `.gitignore` excludes common local build output, dependency folders, IDE files, and environment files.

## Notes and limitations

- Market prices are seeded sample values, not live market data.
- The analysis screen is a scaffold; illustrative metrics should not be treated as live financial information.
- This is an educational paper-trading project, not investment advice or a real trading platform.

## License

No license has been added. If you want others to reuse, modify, or distribute this project, choose and add a license that matches your intentions.
