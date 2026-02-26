FROM postgres:latest

# Set environment variables for database configuration
ENV POSTGRES_DB=group2
ENV POSTGRES_USER=group2
ENV POSTGRES_PASSWORD=123456

# Copy initialization scripts to the image
# These scripts will be executed in alphabetical order when the container starts
COPY init.sql /docker-entrypoint-initdb.d/
COPY books_data.sql /docker-entrypoint-initdb.d/

# Expose the default PostgreSQL port
EXPOSE 5432
