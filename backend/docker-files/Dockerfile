FROM nginx
COPY ./src/main/resources/assets /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY ./docker-files/default.conf /etc/nginx/conf.d

