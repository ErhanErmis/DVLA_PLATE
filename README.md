# DVLA_PLATE

Codes and Tests Prepared by: **Erhan Ermis**

QA Automation Engineer

londoner.han@gmail.com

www.linkedin.com/in/erhan-ermis

Build Tool: Maven

I used Junit a and Java in this task.








<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />

**Background Information**


The modern vehicle registration plate follows this pattern:

B	D	5	1	S	M	R<br />


B	D: Area code<br />	5	1: Age identifier<br />	S	M	R:Random section<br />

All letters are in upper case only.

The area code is two letters long. The first letter indicates the region in which the vehicle was registered and can only be one of the letters in Table 1. For this exercise, assume the second letter is any random letter except ‘I’ (uppercase ‘i’) and ‘Q’.

	
***First Letter	   Region<br />***
A	Anglia<br />
B	Birmingham<br />
C	Cymru (Wales)<br />
D	Deeside<br />
E	Essex	R	Reading<br />
F	Forest and Fens<br />	
G	Garden of England<br />	
H	Hampshire	W	West of England<br />
K	Milton Keynes<br />	
L	London<br />	
M	Manchester<br />
N	Newcastle<br />
O	Oxford<br />
P	Preston<br />
S	Scotland<br />
V	Severn Valley<br />
X	Export<br />
Y	Yorkshire<br />


The age identifier is either the last two digits of the current year if registered between March and August or else has 50 added to it if registered between September and February. For example, “61” indicates a vehicle year registered between September 2011 and February 2012. 

An age identifier of 00 is not permitted. A vehicle cannot be registered to appear younger than it is. For example, the current year is 2022 so a vehicle cannot have a licence plate with an age identifier of 32.

The random section can contain any three letters except the letters ‘I’ (upper case ‘i’) or ‘Q’.

***Scenario***
1.	Given a string of characters, determines if the string is or is not a valid vehicle registration plate value.
2.	Given a string of characters which is a valid vehicle registration value, displays (prints out) the year of registration and region of registration.
