
FROM node:14 AS build


RUN mkdir /app

COPY ./front /app



WORKDIR /app


RUN npm install --only=dev


RUN npm run build


FROM nginx:alpine


COPY --from=build /app/dist /usr/share/nginx/html

COPY --from=build /app /usr/share/nginx/html


COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf


EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
