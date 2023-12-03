# Selenium - Gmail Generator

## Overview

This Java program automates the process of creating Gmail accounts using Selenium WebDriver. It generates random personal information, including names, birthdates, and genders, and utilizes this data to register new Gmail accounts via automation

>_**Note: This project is designed for portfolio demonstration purposes only and does not complete Gmail registration process due to mobile authentication requirements.**_

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
