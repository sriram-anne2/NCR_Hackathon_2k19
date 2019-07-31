//
//  OrderTableViewCell.swift
//  TwitterDemo
//
//  Created by Zachary Maciejewski on 7/31/19.
//  Copyright © 2019 Zachary Maciejewski. All rights reserved.
//

import UIKit

class OrderTableViewCell: UITableViewCell {

    @IBOutlet weak var orderDescriptionLabel: UILabel!
    
    var orderDescription: String? {
        didSet {
            updateUI()
        }
    }
    
    /*
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }*/
    
    func updateUI() {
        //orderDescriptionLabel.text = orderDescription
        
//        var orderDescription = ""
//        let url = "http://localhost:8080/orders"
//        URLSession.shared.dataTask(with: URL(string: url)!) { (data, res, err) in
//            if let d = data {
//                if let value = String(data: d, encoding: String.Encoding.ascii) {
//                    do {
//                        //print(value)
//                        let json = try JSONSerialization.jsonObject(with: d, options: JSONSerialization.ReadingOptions.mutableContainers) as! [[String: AnyObject]]
//                        print(json[0]["orderDescription"]!)
//                        orderDescription = json[0]["orderDescription"]! as! String
//                        self.orderDescriptionLabel.text = orderDescription
//                        //                            if let arr = json["rows"] as? [[String: Any]] {
//                        //                                debugPrint(arr)
//                        //                            }
//                    } catch {
//                        NSLog("ERROR \(error.localizedDescription)")
//                    }
//                }
//
//            }
//            }.resume()
    }
    /*

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        var orderDescription = ""
        let url = "http://localhost:8080/orders"
        URLSession.shared.dataTask(with: URL(string: url)!) { (data, res, err) in
            if let d = data {
                if let value = String(data: d, encoding: String.Encoding.ascii) {
                    do {
                        //print(value)
                        let json = try JSONSerialization.jsonObject(with: d, options: JSONSerialization.ReadingOptions.mutableContainers) as! [[String: AnyObject]]
                        print(json[0]["orderDescription"]!)
                        orderDescription = json[0]["orderDescription"]! as! String
                        self.orderDescriptionLabel.text = orderDescription
                        //                            if let arr = json["rows"] as? [[String: Any]] {
                        //                                debugPrint(arr)
                        //                            }
                    } catch {
                        NSLog("ERROR \(error.localizedDescription)")
                    }
                }
                
            }
            }.resume()
        
        //print(orderDescription)
        
        //orderDescriptionLabel.text = orderDescription
        // Configure the view for the selected state
    }
 */

}
