FROM node:latest as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build
EXPOSE 8083
#stage 2
FROM nginx:alpine
COPY --from=node /app/dist/tmp-app /usr/share/nginx/html