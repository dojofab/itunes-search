//
//  StringExtension.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 2/14/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

extension String {
    func toURL() -> URL? {
        return URL(string: self)
    }
}
