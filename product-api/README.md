
---

# Spring Boot Product API

Ce projet est une application Spring Boot pour gérer des produits avec les opérations CRUD (Create, Read, Update, Delete). Il utilise Hibernate pour la persistance des données et AssertJ pour les assertions dans les tests.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants :

- Java 17 ou version ultérieure
- Maven 3.x
- IDE (Eclipse, IntelliJ IDEA, etc.)
- Base de données MySQL (ou autre, selon votre choix)

## Configuration de la Base de Données

Assurez-vous d'avoir configuré une base de données MySQL locale avec les paramètres suivants :

- Nom de la base de données : `productdb`
- Utilisateur : `root`
- Mot de passe : `password`

Si vous utilisez d'autres paramètres, mettez à jour le fichier `application.properties` dans `src/main/resources`.

```properties
# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/productdb?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Installation

1. Clonez le repository :

   ```bash
   git clone https://github.com/votre-utilisateur/product-api.git
   ```

2. Accédez au répertoire du projet :

   ```bash
   cd product-api
   ```

3. Compilez le projet avec Maven :

   ```bash
   mvn clean install
   ```

## Exécution

Pour exécuter l'application Spring Boot, utilisez la commande suivante :

```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse suivante :

```
http://localhost:8080
```

## Tests

Les tests sont écrits avec JUnit 5 et AssertJ. Pour exécuter les tests, utilisez la commande suivante :

```bash
mvn test
```

## API Endpoints

Voici les endpoints disponibles dans cette API :

- **GET /api/products** : Récupère tous les produits.
- **GET /api/products/{id}** : Récupère un produit par son ID.
- **POST /api/products** : Crée un nouveau produit.
- **PUT /api/products/{id}** : Met à jour un produit existant.
- **DELETE /api/products/{id}** : Supprime un produit par son ID.

## Exemples d'utilisation

### Créer un produit

**POST /api/products**

```json
{
  "name": "PC Dell",
  "price": 2200.5
}
```

### Mettre à jour un produit existant

**PUT /api/products/{id}**

```json
{
  "name": "PC Dell",
  "price": 2000.0
}
```

### Récupérer tous les produits

**GET /api/products**

```json
[
  {
    "id": 1,
    "name": "PC Dell",
    "price": 2200.5,
    "dateCreate": "2024-06-03T15:11:40.189"
  },
  {
    "id": 2,
    "name": "Laptop Lenovo",
    "price": 1500.0,
    "dateCreate": "2024-06-03T15:15:20.002"
  }
]
```


---

