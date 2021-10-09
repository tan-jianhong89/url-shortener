# URL Shortener

## Design Goals
1. Given a long URL it should be able to generate a Short URL.
2. Given a short URL it should automatically redirect to the original URL.
3. A simple frontend with input box for entering the URL to be shortened.
4. Create a suitable Minimum Viable Product

## Future Enhancements
1. Bloom filter can be used to check if any possibility of unique URL already existing to reduce call to DB
2. User Accounts can be used to keep track of the URLs
3. URL should expire after a certain time have elapsed
4. Analytics can be provided to the creator of the short URL on how it's used

## Algorithm
- Character Set - Base 62 [A-Z][a-z][0-9] to allow valid URL string
- Url Length – length 8, will give 64^8 = ~218 Trillion URLs

## Database Choice
- RDBMS database like MySQL will be used for this due to more experience with it
- NoSQL database like MongoDB will be preferred for better scalability, can be used in future

## Database Design
### Shorten URL
- id
- shortUrl
- originalUrl

## Caching for read focused service
- URL Shorten service is read heavy as it should be shared on social media platforms
- Cache layer like Redis will be used to cache the most trending shorten url to get the most benefit

## Deployment
- Service can be deployed to Cloud with GCP Cloud Run, Cloud SQL and Memorystore