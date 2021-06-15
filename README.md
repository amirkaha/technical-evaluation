# technical-evaluation
Created a framework using Selenium in Java, using Testng annotations on Intelij IDE.

Using the page object model, I have create an automation test suite which is simple to understand and collaborate on.

To run, just fork this repository, but you will need to make a folder for screenshots to be stored, eg src/main/resources/screenshots/.

The test will open chromedriver, navigate to Financial Review, wait for Prompt to load in DOM. 

Then Assert that the pop up is visible, I did this by using the xPath locator as it doesn't change upon the pop ups state. 

I then read the value of attribute "datatestid" and create my assertions based on whether the value is True or False.

I then scroll to the bottom of the page and repeat the same, but expecting a false value.
