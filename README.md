# Selenium - Gmail Generator

## Overview

This Java program automates the process of creating Gmail accounts using Selenium WebDriver. It generates random personal information, including names, birthdates, and genders, and utilizes this data to register new Gmail accounts via automation

>_**Note: This project is designed for portfolio demonstration purposes only and does not complete the Gmail registration process due to mobile authentication requirements.**_

## What This Project Entails

With this being my first Selenium project, this project showcases a range of skills, including but not limited to:
  - Web Automation: Utilizing XPath selectors for navigation due to Google's preference over CSS 'id' fields.
  - API integration, to generate and randomize names and passwords.
  - String Manipulation and Randomization: Implemented methods for generating DD/MM/YYYY and gender information.

## Setup

**1. Clone the Repository**

**2. Install Dependencies**

  - Ensure you have a JDK installed.
  - Install the latest Selenium JDK and Gson JDK into your project.
  - Download ChromeDriver and Chrome for Testing from this [link](https://googlechromelabs.github.io/chrome-for-testing).

**3. Set Up Configurations**

  - Create a **config.properties** file in the **src** directory.
  - Add the required properties (**chromedriver**, **chrome.exe**, **api.key**) with their respective paths and keys.
  - **chromedriver**: Path to your local chromedriver.exe file.
  - **chrome.exe**: Path to the compatible Chrome.exe corresponding to your ChromeDriver.
  - **api.key**: Your private API Key for https://api-ninjas.com/

## Improvements

  - Use the gender from the Name generator API instead of randomly generating.
  - Find a better way to read from the config.properties file instead of a method reading the file for each property.
  - Implement implicit/explicit waits instead of Thread.sleep() to ensure the element is on the screen before proceeding with the automation.
  - _Actually complete the registration process._
