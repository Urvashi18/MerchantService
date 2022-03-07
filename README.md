# MerchantService
## The repository holds a merchant service as a crud application to search and query merchant details for user services.

### `merchant-service-backend`
#### Build the backend before running (This creates a backend image)
 1. Build Service Image \
    `gradlew clean build docker` 
    
### `merchant-service-frontend`
[Readme](https://github.com/Urvashi18/MerchantService/blob/master/merchant-service-frontend/README.md)

### Test All Together
  1. Docker compose with mysql image \
    `docker-compose up`
  2. GoTo localhost:3000 
    
### API
[Readme](https://github.com/Urvashi18/MerchantService/blob/master/api.md)

## Potential Optimisations
### Performance
  - Enable in-memory caching and run a scheduler to sync with database
  - (OR) Create a distributed cache (eg: Redis) if the service requirements for upscaling, use cache as primary source i.e. write/read through strategy
### Code
  - Create generic filter structure to allow all different sorts of filters that can be integrated easily 
### Security
  - Use public key encryption in docker compose and docker file and do not expose plaintext
  - API authentication


