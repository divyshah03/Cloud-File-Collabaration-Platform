# Project Structure

Complete folder structure of the File Management System.

```
full-stack-professional/
│
├── backend/                          # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/amigoscode/
│   │   │   │       ├── Main.java                    # Application entry point
│   │   │   │       │
│   │   │   │       ├── domain/                      # Domain Layer (Entities)
│   │   │   │       │   ├── user/
│   │   │   │       │   │   ├── User.java            # User entity with email verification
│   │   │   │       │   │   └── Role.java            # User roles (USER, ADMIN)
│   │   │   │       │   └── file/
│   │   │   │       │       └── File.java            # File entity with metadata
│   │   │   │       │
│   │   │   │       ├── application/                 # Application Layer (Business Logic)
│   │   │   │       │   ├── user/
│   │   │   │       │   │   ├── UserService.java     # User business logic
│   │   │   │       │   │   ├── UserDTOMapper.java   # Entity to DTO mapper
│   │   │   │       │   │   └── AuthenticationService.java
│   │   │   │       │   ├── file/
│   │   │   │       │   │   ├── FileService.java     # File management logic
│   │   │   │       │   │   └── FileDTOMapper.java
│   │   │   │       │   └── email/
│   │   │   │       │       ├── EmailService.java    # Email sending service
│   │   │   │       │       ├── EmailServiceInterface.java
│   │   │   │       │       ├── EmailVerificationService.java
│   │   │   │       │       └── NoOpEmailService.java
│   │   │   │       │
│   │   │   │       ├── infrastructure/              # Infrastructure Layer
│   │   │   │       │   ├── persistence/
│   │   │   │       │   │   ├── user/
│   │   │   │       │   │   │   └── UserRepository.java
│   │   │   │       │   │   └── file/
│   │   │   │       │   │       └── FileRepository.java
│   │   │   │       │   ├── storage/
│   │   │   │       │   │   ├── S3Service.java       # S3 file operations
│   │   │   │       │   │   ├── S3Buckets.java
│   │   │   │       │   │   ├── S3Config.java
│   │   │   │       │   │   └── FakeS3.java          # Local S3 mock
│   │   │   │       │   ├── security/
│   │   │   │       │   │   ├── JWTUtil.java         # JWT token utilities
│   │   │   │       │   │   ├── JWTAuthenticationFilter.java
│   │   │   │       │   │   ├── SecurityConfig.java
│   │   │   │       │   │   ├── SecurityFilterChainConfig.java
│   │   │   │       │   │   └── UserDetailsServiceImpl.java
│   │   │   │       │   └── config/
│   │   │   │       │       └── CorsConfig.java
│   │   │   │       │
│   │   │   │       ├── presentation/                # Presentation Layer (REST API)
│   │   │   │       │   ├── controller/
│   │   │   │       │   │   ├── AuthController.java  # Authentication endpoints
│   │   │   │       │   │   ├── FileController.java  # File management endpoints
│   │   │   │       │   │   └── PingController.java  # Health check
│   │   │   │       │   └── dto/
│   │   │   │       │       ├── user/
│   │   │   │       │       │   ├── UserDTO.java
│   │   │   │       │       │   ├── UserRegistrationRequest.java
│   │   │   │       │       │   ├── AuthenticationRequest.java
│   │   │   │       │       │   ├── AuthenticationResponse.java
│   │   │   │       │       │   └── EmailVerificationRequest.java
│   │   │   │       │       └── file/
│   │   │   │       │           ├── FileDTO.java
│   │   │   │       │           └── FileUploadResponse.java
│   │   │   │       │
│   │   │   │       ├── shared/                      # Shared Utilities
│   │   │   │       │   └── exception/
│   │   │   │       │       ├── GlobalExceptionHandler.java
│   │   │   │       │       ├── ApiError.java
│   │   │   │       │       ├── ResourceNotFoundException.java
│   │   │   │       │       ├── DuplicateResourceException.java
│   │   │   │       │       ├── RequestValidationException.java
│   │   │   │       │       └── DelegatedAuthEntryPoint.java
│   │   │   │       │
│   │   │   │       └── [legacy packages - see docs/LEGACY_CODE.md]
│   │   │   │           ├── auth/                    # DEPRECATED
│   │   │   │           ├── customer/                # DEPRECATED
│   │   │   │           ├── s3/                      # DEPRECATED (use infrastructure/storage)
│   │   │   │           ├── jwt/                     # DEPRECATED (use infrastructure/security)
│   │   │   │           ├── security/                # DEPRECATED (use infrastructure/security)
│   │   │   │           └── exception/               # DEPRECATED (use shared/exception)
│   │   │   │
│   │   │   └── resources/
│   │   │       ├── application.yml                  # Main configuration
│   │   │       ├── application-test.yml             # Test configuration
│   │   │       └── db/
│   │   │           └── migration/                   # Flyway migrations
│   │   │               ├── V1__Create_Users_Table.sql
│   │   │               └── V2__Create_Files_Table.sql
│   │   │
│   │   └── test/                                    # Test files
│   │       ├── java/com/amigoscode/
│   │       │   ├── AbstractTestcontainers.java
│   │       │   ├── TestConfig.java
│   │       │   ├── customer/                        # Customer tests (legacy)
│   │       │   ├── journey/                         # Integration tests
│   │       │   └── s3/                              # S3 tests
│   │       └── resources/
│   │           ├── female.jpeg
│   │           └── male.jpeg
│   │
│   └── pom.xml                                      # Maven configuration
│
├── frontend/
│   │
│   ├── react/                                       # React Frontend (Primary)
│   │   ├── src/
│   │   │   ├── api/
│   │   │   │   └── client.js                        # API client service
│   │   │   │
│   │   │   ├── components/                          # Reusable components
│   │   │   │   ├── file/
│   │   │   │   │   ├── FileCard.jsx                 # File card component
│   │   │   │   │   └── FileUpload.jsx               # File upload with drag-drop
│   │   │   │   └── layout/
│   │   │   │       ├── SideBar.jsx                  # Navigation sidebar
│   │   │   │       └── ProtectedRoute.jsx           # Route guard
│   │   │   │
│   │   │   ├── hooks/                               # Custom React hooks
│   │   │   │   └── AuthContext.jsx                  # Authentication context
│   │   │   │
│   │   │   ├── pages/                               # Page components
│   │   │   │   ├── auth/
│   │   │   │   │   ├── login/
│   │   │   │   │   │   └── Login.jsx
│   │   │   │   │   ├── signup/
│   │   │   │   │   │   └── Signup.jsx
│   │   │   │   │   └── email-verification/
│   │   │   │   │       └── EmailVerification.jsx
│   │   │   │   ├── files/
│   │   │   │   │   ├── Files.jsx                    # File list page
│   │   │   │   │   └── Home.jsx                     # Dashboard/home page
│   │   │   │   └── customers/                       # Legacy customer pages
│   │   │   │       ├── CreateCustomerDrawer.jsx
│   │   │   │       ├── CreateCustomerForm.jsx
│   │   │   │       ├── CustomerCard.jsx
│   │   │   │       ├── UpdateCustomerDrawer.jsx
│   │   │   │       └── UpdateCustomerForm.jsx
│   │   │   │
│   │   │   ├── utils/                               # Utility functions
│   │   │   │   └── notification.js                  # Toast notifications
│   │   │   │
│   │   │   ├── assets/                              # Static assets
│   │   │   │   └── react.svg
│   │   │   │
│   │   │   ├── index.css                            # Global styles
│   │   │   └── main.jsx                             # Application entry point
│   │   │
│   │   ├── public/                                  # Public static files
│   │   │   ├── assets/
│   │   │   └── vite.svg
│   │   │
│   │   ├── Dockerfile                               # Docker configuration
│   │   ├── index.html                               # HTML template
│   │   ├── package.json                             # Dependencies
│   │   ├── vite.config.js                           # Vite configuration
│   │   └── .env                                     # Environment variables
│   │
│   └── angular/                                     # Angular Frontend (Alternative/Legacy)
│       ├── src/
│       │   ├── app/
│       │   │   ├── components/                      # Angular components
│       │   │   ├── models/                          # TypeScript models
│       │   │   └── services/                        # Angular services
│       │   ├── environments/                        # Environment configs
│       │   └── assets/
│       ├── angular.json
│       ├── package.json
│       └── tsconfig.json
│
├── config/                                          # Configuration files
│   └── docker-compose.yml                          # Docker Compose configuration
│
├── docker/                                          # Docker deployment configs
│   └── aws/
│       └── Dockerrun.aws.json                      # AWS Elastic Beanstalk config
│
├── docs/                                            # Documentation
│   ├── API.md                                      # API documentation
│   ├── ARCHITECTURE.md                             # Architecture overview
│   ├── LEGACY_CODE.md                              # Legacy code documentation
│   ├── PROJECT_STRUCTURE.md                        # This file
│   ├── TRANSFORMATION_SUMMARY.md                   # Transformation details
│   ├── BACKEND_README.md                           # Backend-specific docs
│   └── ANGULAR_README.md                           # Angular-specific docs
│
├── scripts/                                         # Utility scripts
│   ├── setup.sh                                    # Setup script
│   ├── start.sh                                    # Start all services
│   └── stop.sh                                     # Stop all services
│
├── logs/                                            # Application logs (gitignored)
│
├── .gitignore                                       # Git ignore rules
├── README.md                                        # Main README
└── pom.xml                                          # Root Maven config (if exists)
```

## Package Organization

### Backend Package Structure

The backend follows **Domain-Driven Design** (DDD) principles:

1. **`domain/`** - Core business entities (User, File, Role)
2. **`application/`** - Business logic and use cases (Services, Mappers)
3. **`infrastructure/`** - External integrations (Database, S3, Security)
4. **`presentation/`** - API layer (Controllers, DTOs)
5. **`shared/`** - Shared utilities (Exceptions, Common code)

### Frontend Structure

The React frontend follows **feature-based organization**:

1. **`pages/`** - Route-based page components
2. **`components/`** - Reusable UI components
3. **`hooks/`** - Custom React hooks
4. **`api/`** - API client services
5. **`utils/`** - Utility functions

## Legacy Code

See `docs/LEGACY_CODE.md` for information about deprecated packages and migration notes.

## Notes

- Old packages (auth, customer, s3, jwt, security, exception) are kept for reference but should not be used
- New code uses the organized structure (domain, application, infrastructure, presentation, shared)
- Both Main.java and FileManagementApplication.java existed - Main.java is now the entry point
- Old customer migrations (V1__Initial_Setup.sql, V2__Add_Customer_Profile_Image.sql) have been replaced by new migrations
