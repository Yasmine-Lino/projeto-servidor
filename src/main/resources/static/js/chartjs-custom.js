$().ready(function() {
	
	var transaction_y = estudantes.map(x=> x["amount"])
	var transaction_x = estudantes.map(x=> x["purpose"])
	
	var lineChartData = {
		labels:["","","","","","",""],
		datasets: [
			{
				fillColor: "rgba(220,220,220,0.5)",
				strokeColor:"rgba(220,220,220,1)",
				pointColor: "rgba(220,220,220,1)",
				pointStrokeColor: "#fff",
				data: transaction_y
			},
			{
				fillColor: "rgba(151,187,205,0.5)",
				strokeColor:"rgba(151,187,205,1)",
				pointColor: "rgba(151,187,205,1)",
				pointStrokeColor: "#fff",
				data: [28,48,40,19,96,27,100]
			}
		]
	};
})