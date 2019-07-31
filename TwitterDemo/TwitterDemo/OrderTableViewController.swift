//
//  OrderTableViewController.swift
//  TwitterDemo
//
//  Created by Zachary Maciejewski on 7/31/19.
//  Copyright © 2019 Zachary Maciejewski. All rights reserved.
//

import UIKit

class OrderTableViewController: UITableViewController {
    
    var orders = [(String, String)]()

    override func viewDidLoad() {
        super.viewDidLoad()
        /*
        let url = "http://localhost:8080/orders"
        URLSession.shared.dataTask(with: URL(string: url)!) { (data, res, err) in
            if let d = data {
                if let value = String(data: d, encoding: String.Encoding.ascii) {
                        do {
                            //print(value)
                            let json = try JSONSerialization.jsonObject(with: d, options: JSONSerialization.ReadingOptions.mutableContainers) as! [[String: AnyObject]]
                            print(json[0]["orderDescription"]!)
//                            if let arr = json["rows"] as? [[String: Any]] {
//                                debugPrint(arr)
//                            }
                        } catch {
                            NSLog("ERROR \(error.localizedDescription)")
                        }
                }
                
            }
            }.resume()*/
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        var orderDescription = ""
        var orderBy = ""
        let url = "http://localhost:8080/orders"
        URLSession.shared.dataTask(with: URL(string: url)!) { [weak self] (data, res, err) in
            if let d = data {
                if let value = String(data: d, encoding: String.Encoding.ascii) {
                    do {
                        //print(value)
                        let json = try JSONSerialization.jsonObject(with: d, options: JSONSerialization.ReadingOptions.mutableContainers) as! [[String: AnyObject]]
                        
                        
                        for order in json {
                            
                            if let orderDes = order["orderDescription"] as? String, let orderBy = order["orderedBy"] as? String {
                                self?.orders.append((orderDes, orderBy))
                            }
                            
                        }
                
                        
                        DispatchQueue.main.async {
                            self?.tableView.reloadData()
                        }
                        
                        //                        if let orderCell = cell as? OrderTableViewCell {
                        //                            orderCell.orderDescription = orderDescription
                        //                        }
                        //self.orderDescriptionLabel.text = orderDescription
                        //                            if let arr = json["rows"] as? [[String: Any]] {
                        //                                debugPrint(arr)
                        //                            }
                    } catch {
                        NSLog("ERROR \(error.localizedDescription)")
                    }
                }
                
            }
            }.resume()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        orders.removeAll()
    }

    // MARK: - Table view data source

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return orders.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Order", for: indexPath)

        let order = orders[indexPath.row]
        
        cell.textLabel?.text = order.0
        cell.detailTextLabel?.text = order.1

        
        
        // Configure the cell...
        //cell.textLabel?.text = "hello"

        
        //cell.textLabel?.text = orderDescription
        //cell.textLabel?.text = tweet.text
        //cell.detailTextLabel?.text = tweet.user.name
//        if let orderCell = cell as? OrderTableViewCell {
//            orderCell.orderDescription = orderDescription
//        }

        return cell
    }

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
