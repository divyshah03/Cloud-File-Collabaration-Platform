# Architecture Overview

## System Architecture

This is a full-stack file management system with the following architecture:

### Backend Architecture (Spring Boot)

```
┌─────────────────────────────────────────────────────┐
│                  Presentation Layer                  │
│  (REST Controllers, DTOs, Request/Response)         │
├─────────────────────────────────────────────────────┤
│                 Application Layer                    │
│  (Business Logic, Services, Use Cases)              │
├─────────────────────────────────────────────────────┤
│                   Domain Layer                       │
│  (Entities, Domain Models, Business Rules)          │
├─────────────────────────────────────────────────────┤
│              Infrastructure Layer                    │
│  (Persistence, Storage, Security, Config)           │
└─────────────────────────────────────────────────────┘
```

### Frontend Architecture (React)

```
┌─────────────────────────────────────────────────────┐
│                    Pages Layer                       │
│  (Route Components, Page Components)                │
├─────────────────────────────────────────────────────┤
│                 Components Layer                     │
│  (Reusable UI Components, Layout Components)        │
├─────────────────────────────────────────────────────┤
│                    Hooks Layer                       │
│  (Custom Hooks, Context Providers)                  │
├─────────────────────────────────────────────────────┤
│                    API Layer                         │
│  (HTTP Client, API Services)                        │
├─────────────────────────────────────────────────────┤
│                   Utils Layer                        │
│  (Utility Functions, Helpers)                       │
└─────────────────────────────────────────────────────┘
```

## Package Structure

### Backend Packages

- **domain/**: Core business entities (User, File)
- **application/**: Business logic and services
  - `user/`: User management services
  - `file/`: File management services
  - `email/`: Email verification services
- **infrastructure/**: External integrations
  - `persistence/`: Database repositories
  - `storage/`: S3 file storage
  - `security/`: JWT and authentication
  - `config/`: Configuration classes
- **presentation/**: REST API layer
  - `controller/`: REST controllers
  - `dto/`: Data Transfer Objects
- **shared/**: Shared utilities
  - `exception/`: Custom exceptions
  - `util/`: Utility classes

### Frontend Structure

- **api/**: API client services
- **components/**: Reusable UI components
  - `file/`: File-related components
  - `layout/`: Layout components (Sidebar, ProtectedRoute)
- **hooks/**: Custom React hooks (AuthContext)
- **pages/**: Route page components
  - `auth/`: Authentication pages (Login, Signup, Email Verification)
  - `files/`: File management pages (Files List, Dashboard)
  - `customers/`: Legacy customer management (deprecated)
- **utils/**: Utility functions (notifications, formatters)

## Data Flow

### File Upload Flow
1. User selects file in React UI
2. File sent to `/api/v1/files` (multipart/form-data)
3. Backend validates file (size, type)
4. File stored in S3 (or FakeS3)
5. Metadata saved to PostgreSQL
6. FileDTO returned to frontend

### Authentication Flow
1. User submits credentials
2. Spring Security validates credentials
3. JWT token generated
4. Token returned in response header
5. Frontend stores token in localStorage
6. Token included in subsequent requests
7. JWT filter validates token on each request

## Security Architecture

- **JWT Authentication**: Stateless token-based authentication
- **Password Encryption**: BCrypt password hashing
- **Role-Based Access Control**: USER and ADMIN roles
- **CORS Configuration**: Configurable CORS for frontend
- **Input Validation**: Bean validation on all endpoints
- **Error Handling**: Global exception handler

## Storage Architecture

- **Database**: PostgreSQL for metadata and user data
- **File Storage**: AWS S3 (or FakeS3 for development)
- **File Organization**: `files/{userId}/{uuid}.ext`
- **Metadata**: Stored in `files` table with foreign key to `users`
