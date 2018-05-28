//
//  iosAppTests.swift
//  iosAppTests
//
//  Created by jetbrains on 12/04/2018.
//  Copyright © 2018 JetBrains. All rights reserved.
//

import XCTest
import Greeting

class iosAppTests: XCTestCase {
    
    func testExample() {
        assert(GreetingGreeting().greeting() == "Hello, iOS")
    }
    
}
