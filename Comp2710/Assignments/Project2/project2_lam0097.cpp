//Lawrence "Alex" Martin
//Project 2
//Code typed on my laptop using Visual Studio Code. 

#include <iostream>
#include <iomanip>
#include <stdlib.h>
#include <assert.h>
#include <ctime>
#include <time.h>
#define TOTAL_RUNS 10000
 
using namespace std;

/**
     *Input A_alive indicates is Aaron is alive true for alive, false for dead.
     *B_Alive indicates Bob is alive.
     *C_Alive indicates Charlie is alive. 
     *Returns: true if at least two are alive.
     *Otherwise Returns false. 
     */

bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive);
void Aaron_shoots1(bool& B_alive, bool& C_alive);
void Bob_shoots(bool& A_alive, bool& C_alive); 
void Charlie_shoots(bool& A_alive, bool& B_alive); 
void Aaron_shoots2(bool& B_alive, bool& C_alive);
void Press_any_key(); 

//TEST PROTOTYPES
void test_at_least_two_alive(void);
void test_Aaron_shoots1(void);
void test_Bob_shoots(void);
void test_Charlie_shoots(void);
void test_Aaron_shoots2(void);

//Variables
bool aaronAlive = true;
bool bobAlive = true;
bool charlieAlive = true;





int main() 
{
	cout << "*** Welcome to Alex's Duel Simulator ***\n";
	srand(time(0));
	test_at_least_two_alive();
	Press_any_key();
	test_Aaron_shoots1();
	Press_any_key();
	test_Bob_shoots();
	Press_any_key();
	test_Charlie_shoots();
	Press_any_key();
	test_Aaron_shoots2();
	Press_any_key();
	
	
	//Starts strategy 1 and runs 10,000 times
	cout<< "Ready to test strategy 1 (run 10000 times):\n";
	Press_any_key();
	int aaronWins1 = 0;
	int bobWins1 = 0;
	int charlieWins1 = 0;
	for(int i = 0; i < TOTAL_RUNS; i++) {
		
		aaronAlive = true;
		bobAlive = true;
		charlieAlive = true;
		while (at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
	
		
			if(aaronAlive)
				Aaron_shoots1(bobAlive, charlieAlive);
			if(bobAlive)
				Bob_shoots(aaronAlive, charlieAlive); 
			if(charlieAlive)
				Charlie_shoots(aaronAlive, bobAlive);
			
			
		}
		if(aaronAlive) {
			aaronWins1++;
		}
		else if(bobAlive) {
			bobWins1++;
		}
		else if(charlieAlive) {
			charlieWins1++;
		}
		
	}
	
	cout<<"Aaron won " << aaronWins1 << "/10000 duels or " << static_cast<double>(aaronWins1)/TOTAL_RUNS * 100 << "%\n";
	cout<<"Bob won " << bobWins1 <<"/10000 duels or " << static_cast<double>(bobWins1)/TOTAL_RUNS * 100 << "%\n";
	cout<<"Charlie won "<< charlieWins1 << "/10000 duels or " << static_cast<double>(charlieWins1)/TOTAL_RUNS * 100 << "%\n" <<endl;
	
	
	//Reinitializes variables and starts stragey 2 to run 10,000
	cout<<"Ready to test 2 (run 10000 times):\n";
	Press_any_key();
	int aaronWins2 = 0;
	int bobWins2 = 0;
	int charlieWins2 = 0;
	for (int i = 0; i < TOTAL_RUNS; i++) {
		
		aaronAlive = true;
		bobAlive = true;
		charlieAlive = true;
		while (at_least_two_alive (aaronAlive, bobAlive, charlieAlive)) {
		
			if(aaronAlive)
				Aaron_shoots2(bobAlive, charlieAlive);
			if(bobAlive)
				Bob_shoots(aaronAlive, charlieAlive); 
			if(charlieAlive)
				Charlie_shoots(aaronAlive, bobAlive);
			cout << endl;
			
		}	
		if(aaronAlive) {
				aaronWins2++;
		}
		else if(bobAlive) {
			bobWins2++;
		}
		else if(charlieWins1) {
			charlieWins2++;
		}
	}
	
	cout<<"Aaron won " << aaronWins2 <<"/10000 duels or " <<static_cast<double>(aaronWins2)/TOTAL_RUNS * 100 <<"%\n";
	cout<<"Bob won " << bobWins2 << "/10000 duels or " <<static_cast<double>(bobWins2)/TOTAL_RUNS * 100 << "%\n";
	cout<<"Charlie won " << charlieWins2 <<"/10000 duels or " <<static_cast<double>(charlieWins2)/TOTAL_RUNS * 100 << "%\n"<<endl;
	
	if(aaronWins1 > aaronWins2) {
		cout<<"Strategy 1 is better than strategy 2.\n";
	}
	
	else {
		cout<<"Strategy 2 is better than strategy 1.\n";
	}
	
	return 0;

}


//Implementation of functions. Look above for documentation
bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive) {
	
	//Cheecks for Aaron and Bob
	if (A_alive && B_alive) {
        return true;
    }
	
	//Checks for Aaron and Charlie
    if (A_alive && C_alive) {
        return true;
    }

	//Checks for Bob and Charlie
    if (B_alive && C_alive) {

        return true;

    } 
	else {
        return false;
    }
    
}

void test_at_least_two_alive(void) {
	cout<<"Unit Testing 1: Function-at_least_two_alive()\n";

    //Test if all three true
	cout<<"\tCase 1: Aaron alive, Bob alive, Charlie alive\n";
	assert(at_least_two_alive(true, true, true));
	cout << "\tCase passed ...\n";
	
    //tests if two are true
    cout<<"\tCase 2: Aaron dead, Bob alive, Charlie alive\n";
	assert(at_least_two_alive(false, true, true));
	cout << "\tCase passed ...\n";

    //tests if two are true
    cout << "\tCase 3: Aaron alive, Bob dead, Charlie alive\n";
	assert(at_least_two_alive(true, false, true));
	cout << "\tCase passed ...\n";

    //tests if two are true
    cout << "\tCase 4: Aaron alive, Bob alive, Charlie dead\n";
	assert(at_least_two_alive(true, true, false));
	cout << "\tCase passed ...\n";

    //tests if two are false
    cout << "\tCase 5: Aaron dead, Bob dead, Charlie dead\n";
	assert(!at_least_two_alive(false, false, true));
    cout << "\tCase passed ...\n";

    //tests if two are false
    cout << "\tCase 6: Aaron dead, Bob alive, Charlie dead\n";
 	assert(!at_least_two_alive(false, true, false));
    cout << "\tCase passed ...\n";

    //tests if two are false
    cout << "\tCase 7: Aaron alive, Bob dead, Charlie dead\n";
    assert(!at_least_two_alive(true, false, false));
    cout << "\tCase passed ...\n";

    //tests if all three are false
    cout << "\tCase 8: Aaron dead, Bob dead, Charlie dead\n";
    assert(!at_least_two_alive(false, false, false));
    cout << "\tCase passed ...\n";
}


//Aaron shoots 
void Aaron_shoots1(bool &B_alive, bool &C_alive) {
	assert(B_alive || C_alive);
	
	int shootResult = rand()%100 + 1;
	if(C_alive) {
		 if (shootResult <= 33) {
            C_alive = false;
 		}
	}
	else {
        if (shootResult <= 33) {
            B_alive = false;
        } 
	}
}

//test Aaron shoots
void test_Aaron_shoots1(void) {
	cout<<"Unit Testing 2: Function Aaron_shoots1(Bob_alive, Charlie_alive)\n";
	
	bool bob_a = true;
	bool charlie_a = true;
	cout<<"\tCase 1: Bob alive, Charlie alive\n"
		<<"\t\tAaron is shooting at Charlie\n";
	Aaron_shoots1(bob_a, charlie_a);
	
	bob_a = false;
	charlie_a = true;
	cout<<"\tCase2: Bob dead, Charlie alive\n"
		<<"\t\tAaron is shooting at Charlie\n";
	Aaron_shoots1(bob_a, charlie_a);
	
	bob_a = true;
	charlie_a = false;
	cout << "\tCase 3: Bob alive, Charlie dead\n"
		 << "\t\tAaron is shooting at Bob\n";
	Aaron_shoots1(bob_a, charlie_a);	
}

//Bob shoots
void Bob_shoots(bool& A_alive, bool& C_alive) {
	assert(A_alive || C_alive);
	
	int shootResult = rand()%100 + 1;
	if (C_alive) {
        if (shootResult <= 50) {
            C_alive = false;
        }
    }
    else if (A_alive){
        if (shootResult <= 50) {
            A_alive = false;
        } 
    }
}

//test Bob shoots
void test_Bob_shoots(void) {
	cout<<"Unit Testing 3: Function Bob_shoots(Aaron_alive, Charlie_alive)\n";
	
	bool aaron_a = true;
	bool charlie_a = true;
	cout<<"\tCase 1: Aaron alive, Charlie alive\n"
		<<"\t\tBob is shooting at Charlie\n";
	Bob_shoots(aaron_a, charlie_a);
	
	aaron_a = false;
	charlie_a = true;
	cout<<"\tCase2: Aaron dead, Charlie alive\n"
		<<"\t\tBob is shooting at Charlie\n";
	Bob_shoots(aaron_a, charlie_a);
	
	aaron_a = true;
	charlie_a = false;
	cout << "\tCase 3: Aaron alive, Charlie dead\n"
		 << "\t\tBob is shooting at Aaron\n";
	Bob_shoots(aaron_a, charlie_a);	
}

//Charlie shoots
void Charlie_shoots(bool& A_alive, bool& B_alive) {
	assert(A_alive || B_alive);
	
	int shootResult = rand()%100 + 1;
	if (B_alive) {
        B_alive = false;
    }
    else if (A_alive){
        A_alive = false;
    }
}

//test Charlie shoots
void test_Charlie_shoots(void) {
	cout<<"Unit Testing 4: Function Charlie_shoots(Aaron_alive, Bob_alive)\n";
	
	bool aaron_a = true;
	bool bob_a = true;
	cout<<"\tCase 1: Aaron alive, Bob alive\n"
		<<"\t\tCharlie is shooting at Bob\n";
	Bob_shoots(aaron_a, bob_a);
	
	aaron_a = false;
	bob_a = true;
	cout<<"\tCase2: Aaron dead, Bob alive\n"
		<<"\t\tCharlie is shooting at Bob\n";
	Bob_shoots(aaron_a, bob_a);
	
	aaron_a = true;
	bob_a = false;
	cout << "\tCase 3: Aaron alive, Charlie dead\n"
		 << "\t\tCharlie is shooting at Aaron\n";
	Bob_shoots(aaron_a, bob_a);	
}

//Aaron Startegy 2
void Aaron_shoots2 (bool& B_alive, bool& C_alive) {
	int shootResult = rand() % 100 + 1;

    assert(B_alive || C_alive);
    if (B_alive && C_alive) {
        
   	
    } 
	else if (B_alive) {
        if (shootResult <= 33) {
            B_alive = false;
        } 
    } 
	else if (C_alive) {
        if (shootResult <= 33) {
            C_alive = false;
        } 
    }
}

//Test Strategy 2
void test_Aaron_shoots2(void) {
	cout<<"Unit Testing 5: Function Aaron_shoots2(Bob_alive, Charlie_alive)\n";
	
	bool bob_a = true;
	bool charlie_a = true;
	cout<<"\tCase 1: Bob alive, Charlie alive\n";
	cout << "\t\tAaron intentionally misses his first shot\n";
 	cout << "\t\tBoth Bob and Charlie are alive.\n";
	Aaron_shoots2(bob_a, charlie_a);
	
	bob_a = false;
	charlie_a = true;
	cout<<"\tCase2: Bob dead, Charlie alive\n"
		<<"\t\tAaron is shooting at Charlie\n";
	Aaron_shoots2(bob_a, charlie_a);
	
	bob_a = true;
	charlie_a = false;
	cout << "\tCase 3: Bob alive, Charlie dead\n"
		 << "\t\tAaron is shooting at Bob\n";
	Aaron_shoots2(bob_a, charlie_a);	
}

//Press any key function
void Press_any_key(void){
	cout <<"Press any key to continue...";
	cin.ignore().get();
}
