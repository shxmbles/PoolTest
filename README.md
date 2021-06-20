# PoolTest
Design Document
<br>
Blake Warner
<br>
Katherine Dipaola
<br>
Howard Hall
<br>
Haseeb Ikram
<br>

<h2>INTRODUCTION</h2>
Takes input from the user about their pool chemical levels and provides guidance to improve said levels with through various methods in order to maintain a healthy swimming environment.

<h2>STORYBOARD</h2>
![pool tester](https://user-images.githubusercontent.com/56894894/120109395-45013080-c137-11eb-8dbf-42044cb5614d.PNG)

<h2>FUNCTIONAL REQUIREMENTS</h2>
<h4>SCENARIO</h4>
As a user who upkeeps a pool I wish to monitor and understand the various chemical aspects of my pool.

<h4>ASSUMPTIONS</h4>
Numbers are input in a float point format

<h4>EXAMPLES</h4>
Given the app is making proper calculations

When I input a pH level of 6.5 & a pool size of 16000 gallons

Then I should recieve proper guidance and chemical recommendations to return it to a safe pH range: "Your pH level is too low, add 4.5oz of dry acid to your pool. Do not swim for 8 hours after application."

<h4>ASSUMPTIONS</h4>
Numbers are input in a float point format

<h4>EXAMPLES</h4>
Given the app is making proper calculations

When I input a CYA value of -500

Then I should recieve a message asking for a vaild input range: "That is not a valid input, please input a positive number in the range (range for chemical)."

<h2>CLASS DIAGRAM</h2>

![Chemicals](https://user-images.githubusercontent.com/70410161/120087131-73d5c300-c0b3-11eb-98e1-3f99463dea2b.jpeg)

<h2>CLASS DIAGRAM DESCRIPTION</h2>

MainActivity: The first screen the user sees, which will have areas to input different specifications about their pool.

PoolDetailActivity: Displays information about the current state of the user's pool, and what they can do to improve it.

Chemical: Noun class that represents various pool chemicals.

<h2>ROLES</h2>

DevOps/Product Owner/Scrum Master: Howie Hall
<br>
Frontend Developer: Katie Dipaola
<br>
Frontend Inegration Specialist: Hasseb Ikram
<br>
Integration Developer: Blake Warner, Alexander Pugh
<br>


<h2>WEEKLY MEETING</h2>

Facetime @ 7:00PM every Sunday
