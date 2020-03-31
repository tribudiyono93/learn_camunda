How to run :
 - run camunda web application
 - deploy bpmn process
 - run com.tribudiyono39.charge.card.worker.ChargeCardWorker
 - curl -H "Content-Type: application/json" -X POST -d '{"variables": {"amount": {"value":555,"type":"long"}, "item": {"value":"item-xyz"} } }' http://localhost:8080/engine-rest/process-definition/key/payment-retrieval/start
 - see java console at previous step.