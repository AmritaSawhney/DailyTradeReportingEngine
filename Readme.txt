Daily Trade Reporting Engine

The daily trade reporting engine is intended to process instructions related to various customers. The input instructions are read from the sample txt file, with the
default format and output is the report for :
a. Amount in USD settled incoming everyday
b. Amount in USD settled outgoing everyday
c. Ranking of entities for incoming transactions
d. Ranking of entities for outgoing transactions

The instruction is the model that depicts the instruction being sent by different customer for buy/sell transactions:

Entity: Entity name for the transaction
Instruction: Either Buy/Sell operation
AgreedFx: The foreign exchange for different currencies
Currency: Currency being used for the instruction
Instruction Date: Date on which instruction is received
Settlement Date: Date on which instruction is settled
Units: No.of units involved in the transaction
UnitPrice: Unit Price for each entity for the corresp. instruction

Assumptions:

a. The instruction data is being read from the sample.txt file located in src/main/resources folder.
b. All the inputs are valid, no need for validations provided in code for the incoming instructions.
c. Report generated is displayed on console, not stored in memory.database.
d. Single threaded process.

Execution Steps:

a. As per requirement, an instruction can be settled only on valid working date, and for each transaction settlement date is derived on the basis of currency
code being supplied in instruction input, if:
i. Currency is AED/SAR: the working days are: SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY
ii. Currency is other than AED/SAR: the working days are: MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY

The design pattern used to represent the above scenario is Strategy design pattern, that is implemented in the code.

b. Calculation of incoming amount in USD settled for a particular settlement date: this is implemented using the Utility class static method.

c. Calculation of outgoing amount in USD settled for a particular settlement date: this is implemented using the Utility class static method.

d. Ranking of incoming and outgoing entities on the basis of amount settled for a particular settlement date: this is implemented using the Utility class static
method.

Output:

The report shows the output in following order on console:

a. Amount in USD settled incoming everyday
b. Amount in USD settled outgoing everyday
c. Ranking of entities on the basis of the USD amount settled incoming everyday
d. Ranking of entities on the basis of the USD amount settled outgoing everyday