
# Labelcious

Lablecious is a catering system with 2 versions. The first one is a mobile version dedicated to the clients and the second one is a web version dedicated for both clients and admins.
The application has a scalable system that allows clients to choose and order their plates from each category from the menu of today. The menus are created by the admins and each menu has multiple plates.


## Tech Stack

**Mobile app:** Flutter, Dart, Getx, Google Auth

**Server:** Java, Springboot, Maven

**Web:** Angular, Typescript, Ngrx

**Tools:** Docker

**Database:** Postgres, Firebase


## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`POSTGRES_DB`

`POSTGRES_USER`

`POSTGRES_PASSWORD`

`SPRING_DATASOURCE_URL`

`SPRING_DATASOURCE_USERNAME`

`SPRING_DATASOURCE_PASSWORD`

`SPRING_JPA_HIBERNATE_DDL_AUTO`




## Deployment

Before running the project don't forget to add the environmment variables mentionned above.

To run the mobile app you need to run the server first of all. You have two options to do that you can eitheir run it from docker by using a postgres image or run it locally. If you choose the first option you need to browse to backend folder

```bash
  cd backend
```

After you need to build the image using this command

```bash
  docker build -t your-image-name .
```

And you can run the docker image

```bash
  docker run your-image-name
```

If you choose the second option to run it locally you need to use this command

```bash
  mvn spring-boot:run
```

After that you can run the flutter app using this command 

```bash
  flutter run
```

To run the web application you need to browse to labelcious_web folder 

```bash
  cd labelcious_web
```

After that you can simply run this command

```bash
  docker-compose up -d
```
## Authors

- [@AhmedEnnaime](https://github.com/AhmedEnnaime)


## Feedback

If you have any feedback, please reach out to us at ahmedennaime20@gmail.com


## Support

For support, email ahmedennaime20@gmail.com or join me at Linkedin Ahmed Ennaime.

