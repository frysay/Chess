Basic Docker HowTo:

	1 - From the Dockerfile directory run "docker build -t chess:latest ." to build the docker image
	2 - Run "docker image ls" to see the list of the docker images and check if yours is present
	3 - Run "docker run -d -p 8080:8080 chess:latest" to start the docker container with your application
	4 - Run "docker ps" to check the current containers running
	5 - Run "docker container stop {container_id}" to stop the container with the id = {container_id}

Basic Kubernetes/Minikube HowTo:

	Preconditions:
		1 - minikube start
		2 - 'eval $(minikube docker-env)' (do it on any terminal if you want to access the docker images)
		3 - 'docker build -t {tag to use} .'
		4 - change the deplyment.yaml field image to the name used above ("tag to use") or use "chess-minikube"
		
	Once started:
		1 - 'kubectl apply -f deployment.yaml' (run the deployment as in the yaml)
		2 - 'export POD_NAME=$(kubectl get pods -o go-template --template '{{range .items}}{{.metadata.name}}{{"\n"}}{{end}}')' (For simplicity use farther on)
		3 - 'kubectl logs -f $POD_NAME' (check logs)
		4 - 'curl $(minikube ip):{nodePort}' (check that the service is accessible from outside)

	Other commands:
		1 - 'kubectl version' (check that both Client Version and Server Version are there)
		2 - 'kubectl get nodes' (to see that minikube is up and running)
		3 - 'kubectl get deployments'
		4 - 'kubectl describe deployment [optional] {tag of deployment}'
		5 - 'kubectl describe pod [optional] {tag of pod}'
		6 - 'kubectl proxy'
		7 - 'curl http://localhost:8001/api/v1/namespaces/default/pods/$POD_NAME/proxy/'
		8 - 'kubectl exec $POD_NAME env' (list the env variables)
		9 - 'kubectl exec -ti $POD_NAME /bin/sh' (start a bash inside the pod)
		10 - 'kubectl delete pods $POD_NAME' (stop a pod)
		11 - 'kubectl delete deployments {deployment name}' (stop a deployment)
		12 - 'minikube dashboard'
