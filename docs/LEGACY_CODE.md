# Legacy Code Archive

This document describes old/legacy code that has been replaced but kept for reference.

## Old Backend Packages (Deprecated)

The following packages in `backend/src/main/java/com/amigoscode/` are **deprecated** and replaced by the new structure:

- **`auth/`** → Replaced by `application/user/` and `presentation/controller/AuthController`
- **`customer/`** → Replaced by `domain/user/` and `application/user/`
- **`s3/`** → Replaced by `infrastructure/storage/`
- **`jwt/`** → Replaced by `infrastructure/security/JWTUtil` and `JWTAuthenticationFilter`
- **`security/`** → Replaced by `infrastructure/security/`
- **`exception/`** → Replaced by `shared/exception/`

## Old Files

- **`Main.java`** → Replaced by `FileManagementApplication.java`
- **`PingPongController.java`** → Moved to `presentation/controller/PingController.java`

## Migration Notes

All imports have been updated to use the new package structure. The old packages are kept for reference but should not be used in new code.

If you need to reference old implementations, check the git history or see `TRANSFORMATION_SUMMARY.md` for migration details.

## Cleanup Recommendation

These old packages can be safely removed after verifying all functionality works with the new structure:

```bash
# After testing, you can remove:
backend/src/main/java/com/amigoscode/auth/
backend/src/main/java/com/amigoscode/customer/
backend/src/main/java/com/amigoscode/s3/
backend/src/main/java/com/amigoscode/jwt/
backend/src/main/java/com/amigoscode/security/
backend/src/main/java/com/amigoscode/exception/
backend/src/main/java/com/amigoscode/Main.java
```
