# import names
. ./build/release.cfg

# grab projectid from google
projectid=$(curl -s 'http://metadata/computeMetadata/v1/project/project-id' -H 'Metadata-Flavor: Google')
artifactname=gcr.io/$projectid/$servicename:$servicemajor.$serviceminor.$BUILD_NUMBER

# build
./build/build.sh
docker build -t $artifactname ./container/

# push
gcloud preview docker push $artifactname
