. ./build/release.cfg

projectid=$(curl -s 'http://metadata/computeMetadata/v1/project/project-id' -H 'Metadata-Flavor: Google')
artifactname=gcr.io/$projectid/$servicename:$servicemajor.$serviceminor.$BUILD_NUMBER


./build/build.sh


docker build -t $artifactname ./container/

gcloud preview docker push $artifactname
