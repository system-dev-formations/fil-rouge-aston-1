# BUILD
FROM node:15.12.0-alpine AS build
LABEL stage=build
WORKDIR src/app
COPY package.json ./
RUN npm install
COPY . .
RUN npm run build

# RUN
FROM nginx:1.19.10-alpine
MAINTAINER groupe2
COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=build src/app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
