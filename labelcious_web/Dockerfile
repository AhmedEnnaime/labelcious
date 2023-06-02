FROM node:19-alpine AS build

WORKDIR /app/labelcious_web

COPY package*.json ./

RUN npm install -g @angular/cli

COPY . .

RUN npm install && \
    ng build

FROM nginx:1.17.1-alpine

COPY --from=build /app/labelcious_web/dist/labelcious_web /usr/share/nginx/html

EXPOSE 80

