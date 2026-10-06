FROM jenkins/jenkins:lts

USER root

RUN apt-get update \
    && apt-get install -y --no-install-recommends \
    python3 \ 
    python3-pip \ 
    python3-venv \ 
    python-is-python3 \
    #&& apt-get install -y --no-install-recommends openjdk-17-jdk 
    maven \
    && rm -rf /var/lib/apt/lists/*

USER jenkins
