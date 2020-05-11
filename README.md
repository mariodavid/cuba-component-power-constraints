[![Build Status](https://travis-ci.com/mariodavid/cuba-component-power-constraints.svg?branch=master)](https://travis-ci.com/mariodavid/cuba-component-power-constraints)
[ ![Download](https://api.bintray.com/packages/mariodavid/cuba-components/cuba-component-power-constraints/images/download.svg) ](https://bintray.com/mariodavid/cuba-components/cuba-component-power-constraints/_latestVersion)
[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

# CUBA Component - Power Constraints

This application component allows to extend the security subsystem of CUBA in order to assign constraints not only to Access Groups, 
but also to Roles and Users directly.


Table of Contents
=================

  * [Installation](#installation)
  * [Using the application component](#using-the-application-component)


## Installation

1. `power-constraints` is available in the [CUBA marketplace](https://www.cuba-platform.com/marketplace/power-constraints)
2. Select a version of the add-on which is compatible with the platform version used in your project:

| Platform Version | Add-on Version |
| ---------------- | -------------- |
| 7.2.x            | 0.1.x          |


The latest version is: [ ![Download](https://api.bintray.com/packages/mariodavid/cuba-components/cuba-component-power-constraints/images/download.svg) ](https://bintray.com/mariodavid/cuba-components/cuba-component-power-constraints/_latestVersion)

Add custom application component to your project:

* Artifact group: `de.diedavids.cuba.powerconstraints`
* Artifact name: `powerconstraints-global`
* Version: *add-on version*

```groovy
dependencies {
  appComponent("de.diedavids.cuba.powerconstraints:powerconstraints-global:*addon-version*")
}
```


### CHANGELOG

Information on changes that happen through the different versions of the application component can be found in the [CHANGELOG](https://github.com/mariodavid/cuba-component-power-constraints/blob/master/CHANGELOG.md).
The Changelog also contains information about breaking changes and tips on how to resolve them.



## Using the application component


### Example usage
To see this application component in action, check out this example: [cuba-example-using-power-constraints](https://github.com/mariodavid/cuba-example-using-power-constraints).
