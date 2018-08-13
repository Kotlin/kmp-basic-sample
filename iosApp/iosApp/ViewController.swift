//
//  ViewController.swift
//  iosApp
//
//  Created by jetbrains on 12/04/2018.
//  Copyright © 2018 JetBrains. All rights reserved.
//

import UIKit
import Greeting

class ViewController: UIViewController {
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        let gret = GreetingGreeting()
        
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 200, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.text = "I'am a test label" + gret.greetingCalc()
        self.view.addSubview(label)
        
        
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

