package com.example.temporal.activities;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceClient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class GreetingWorker {
	public static void main(String[] args) {
		// Initialize the service and client
		WorkflowStubs service = WorkflowServiceStubs.newLocalServiceStubs();
		WorkflowClient client = WorkflowClient.newInstance(service);

		// Create Worker Factory and Worker
		WorkerFactory factory = WorkerFactory.newInstance(client);
		Worker worker = factory.newWorker("greeting-tasks");

		// Register the Workflow and Activity Implementations
		Worker.registerWorkflowImplementationTypes(GreetingWorkflowImpl.class);
		worker.registerActivitiesImplementations(new GreetingActivitiesImpl());

		// Start the worker to process the tasks
		factory.start();
	}
}
