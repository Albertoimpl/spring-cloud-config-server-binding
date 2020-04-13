# Setup

Building spring-cloud-config-server image
```shell script
pushd spring-cloud-config-server >/dev/null
./gradlew bootBuildImage --imageName=albertoimpl/spring-cloud-config-server
popd >/dev/null

docker push albertoimpl/spring-cloud-config-server
```

Creating a config-server service instance:
```shell script
kubectl apply -f k8s/config-server-deployment.yaml
```

```shell script
kubectl port-forward pod/my-config-server-689956457-v8p4h 8080:8080

curl localhost:8080/default/master
```

Building config-server-client-app image

```shell script
pushd spring-cloud-config-client-app >/dev/null
./gradlew bootBuildImage --imageName=albertoimpl/spring-cloud-config-client-app
popd >/dev/null

docker push albertoimpl/spring-cloud-config-client-app
```

# Binding the client application to the service instance, the hard way

Creating a service to access the config-server
```shell script
kubectl apply -f k8s/config-server-service.yaml
```

Creating the config-map with the URI pointing to the service
```shell script
kubectl apply -f k8s/config-server-config-map.yaml
```

Deploying the spring-cloud-config-client-app client application pointing to the created config-map and updating the bootstrap location:
```shell script
kubectl apply -f k8s/client-application-deployment-with-configmap.yaml
```

```shell script
k port-forward pod/my-client-app-86d564d688-pn42d 8081:8081

curl localhost:8081/text
GitHub configuration repository!!!!!%
```

# Binding the client application to the service instance, using `spring-cloud-config-server-binding-reconciler`
