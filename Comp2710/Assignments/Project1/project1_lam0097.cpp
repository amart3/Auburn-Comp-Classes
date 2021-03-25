//Lawrence "Alex" Martin
//Project1
//Code typed on my laptop using Visual Studio Code. 
//Received help with the formula/ Format from former student (kzd0030)

#include<iostream>
#include<iomanip>
using namespace std;

int main() 
{
	
	//Variabls
   	int month = 0;
	double loan = 0;
	double interest = 0;
	double interestRateC; 
	double monthlyPayment = 0;
	double balance = 0;
	double intTotal = 0;
   	double interestTotal = 0;
	
	//From Dr. Li's handout 
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(2);
	
	
	//User Input
	cout << "Loan Amount: ";
	cin >> loan;
	
	while (1 > 0){
		if(loan >= 0){
			break;
		}
		else {
			cout <<	"Loan Amount has to be positive\nLoan Amount: ";
			cout << "Loan Amount: ";
			cin >> loan;	
		}
	}
	
	cout << "Interest Rate (% per year): ";
	cin >> interest;
	
	while (1 > 0){
		if(interest	 >= 0){
			break;
		}
		else {
			cout <<	"Interest Rate has to be positive\nLoan Amount: ";
			cout << "Interest Rate (% per year): ";
			cin >> interest;	
		}
	}
	
	interest /=12;
	interestRateC = interest / 100;
	intTotal = loan * interestRateC;
	
	cout << "Monthly Payements: ";
	cin >> monthlyPayment;
	
	while (1 > 0){
		if(interest	 >= 0){
			break;
		}
		else {
			cout <<	"Monthly Payments has to be positive\nLoan Amount: ";
			cout << "Monthly Payments: ";
			cin >> monthlyPayment;	
		}
	}
	
	
	
	
	cout << endl;

	
	
	//Show the Amoratizaton table
   //Reminds you that the regular payment must be bigger than the Monthly Payment.
	if (intTotal > monthlyPayment) {
		cout << "Sorrry, but regular payments have to be more than Monthly payments\n";
	
	}
	else {
		cout << "*****************************************************************\n"
	 		<< "\tAmortization Table\n"
		 	<< "*****************************************************************\n"
		 	<< "Month\tBalance\t\tPayment\tRate\tInterest\tPrincipal\n";
	while (loan > 0) {
		if (month == 0) {
			cout << month++ << "\t$" << loan << "\t" << "N/A\tN/A\tN/A\t\tN/A\n";
			if (loan < 1000) 
				cout << "\t";
		}
		
		//Calculations
      //Help from former student kzd0030
		else {
			intTotal = loan * interestRateC;
			balance = monthlyPayment - intTotal;
			loan -= balance;
			interestTotal += intTotal;
			
			
			//Found help with this portion on stack overflow. Could  not get table to show completely.
			//Help from former student on how to set up input for table. kdz0030 
			std::cout << std::left << setw(7) << month << "$" << std::left << setw(14) << loan <<"$"
					<< std::left << setw(8) 
               << monthlyPayment << std::left << setw(7) << interest << "$"
					<< std::left << setw(8) 
               << intTotal << "\t$" << std::left << setw(4) 
               << balance << "\n";
					
			month++;
			
			//Code for the month total. 
			//Help from friend who took the class Kdz0030
			if (loan	< monthlyPayment) {
				intTotal = loan * interestRateC;
				balance = loan;
				monthlyPayment -= (monthlyPayment - intTotal) - loan ;
				loan = 0;
				interestTotal +=intTotal;
				
				cout << month << "\t";
				cout << "$" << loan;
				cout << "\t\t$" << monthlyPayment <<"\t";
				cout << interest << "\t";
				cout << "$" << intTotal << "\t";
				cout << "\t$" << balance << "\n";
				break;
			}
		}
		
	}
	
	
	//From Dr. Li's handout. 
	cout<< "*****************************************************************\n"
		<< "\nIt takes " << month << " months to pay off "
		<< "the loan.\n"
		<< "total interest paid is: $" << interestTotal;
	cout<< endl << endl;
	}
	return 0;	
}
