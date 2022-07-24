# GraduationProject
Request and Response
•	http://localhost:4444/customer/create => The customer's first and last name are entered in JSON format. Explanation = "Customer Created".
•	http://localhost:4444/customer/get => list of customers 
•	http://localhost:4444/customer/get/{id} =>The customer list is fetched by the customer number.
•	http://localhost:4444/customer/delete/{id} => The customer is deleted based on the customer number. Explanation = " Customer deleted".
•	http://localhost:4444/customer/update/{id} => The customer is updated based on the customer number.
•	http://localhost:4444/bill/create => Information about the invoice is entered in Json format. Explanation = "Bill created".
•	http://localhost:4444/bill/total-amount/{customerId} => Total invoice debt is calculated. The amount owed is shown. If debt = 0  Explanation ="You have no debt".
•	http://localhost:4444/bill/bill-list/{customerId} => The list of invoices is returned by customer number.Total invoice debt is calculated. The amount owed is shown. If debt = 0  Explanation =" You don't have any unpaid invoices"
•	http://localhost:4444/bill/get/{id} => An invoice list is returned based on the invoice number. If status=0, the invoice list is shown. status=1 if Explanation ="You don't have any unpaid invoices".
•	http://localhost:4444/bill/get => The whole invoice list is retrieved. It is seen as status=1 in paid invoices and status=0 in unpaid invoices.
•	http://localhost:4444/bill/delete/{id} => The invoice is deleted based on the invoice number.
•	http://localhost:4444/payment/create => Information about the payment is entered in Json format. Explanation = Payment created". If the amount entered the invoice payment process is less than the invoice amount, an exception message is generated. Explanation = "Insufficient balance". If  debt = 0 Explanation = "You don't have any unpaid invoices"
•	http://localhost:4444/payment/get => list of payments.
•	http://localhost:4444/payment/get/{id} => the payment list is fetched by payment number.

