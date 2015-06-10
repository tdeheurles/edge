FROM java:7
ADD stage /edge/
EXPOSE 2500
CMD chmod u+x /edge/bin
ENV LANG en_US.UTF-8
ENTRYPOINT /edge/bin/edge -Dhttp.port=2500
