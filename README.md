## JavaDevs
- Platform to find a list of all Java Developers in Nairobi

## Description

- JavaDevs is an Android app that provides users with links to github repositories of all java developers in Nairobi.

## Badges

[![Maintainability](https://api.codeclimate.com/v1/badges/94c7e133cb01ed229145/maintainability)](https://codeclimate.com/github/tomuhenry/JavaDevs/maintainability)
[![CircleCI](https://circleci.com/gh/tomuhenry/JavaDevs/tree/develop.svg?style=svg)](https://circleci.com/gh/tomuhenry/JavaDevs/tree/develop)
[![codecov](https://codecov.io/gh/tomuhenry/JavaDevs/branch/develop/graph/badge.svg)](https://codecov.io/gh/tomuhenry/JavaDevs)

## Getting Started

Follow the Instructions below to have the Application running on your local machine

### Prerequisites
- Android Studio 
- JDK 
- Git 

## Android setup

This Project is built with `Java`. It also has unit tests and Espresso UI tests.

### Installation

- Clone the repo by running this command in your terminal 
`git clone https://github.com/tomuhenry/JavaDevs.git` 
- Import the project into android studio 
- Create an `Android Virtual Device` (AVD) or connect an `android device` to your machine
- Run the project 
- Run the tests

### Testing

JUnit unit tests can be run using one of the following:

`./gradlew jacocoTestCoverage`
`./gradlew jacocoTestReport`

### Fastlane

Fastlane is used to automate sharing of debug sample APK's on slack. To set it up;

- Install fastlane
`brew cask install fastlane`

- Setup Slack environment variables for SLACK_URL and SLACK_TOKEN
- Run `fastlane` in the terminal

### Mockups/Wireframe

For the mockup design, I used an online site called [marvelapp](https://marvelapp.com/). 
I chose this resource because:
- It is easy to use and comes with preset views which make the designing process fast
- It is also easier to share the mockups using such online resources as compared to the offline ones
- The online site also allows me to work on the mockup wherever I am using any computer that I choose to use

[Link to Mockups](https://marvelapp.com/gjd68cj/screen/54658244)

### Demo file

![demo-gif](wireFrames/JavaDevsNairobi.gif)