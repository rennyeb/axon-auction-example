/*
 * Copyright (c) 2010. Axon Auction Example
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fuin.auction.client.swing;

import org.fuin.auction.command.api.exceptions.AuctionCmdService;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * Temporary test class to check server connection.
 */
public final class VerifyExample {

	/**
	 * Private constructor to avoid instantiation.
	 */
	private VerifyExample() {
		throw new UnsupportedOperationException("You cannot create an instance of a utility class!");
	}

	/**
	 * Dummy test method.
	 * 
	 * @param args
	 *            Not used.
	 * 
	 * @throws Exception
	 *             Some error happened.
	 */
	public static void main(final String[] args) throws Exception {

		System.out.println("java.io.tmpdir=" + System.getProperty("java.io.tmpdir"));

		final HessianProxyFactory factory = new HessianProxyFactory();

		final AuctionCmdService cmdService = new AuctionCmdServiceImpl(factory,
		        "http://localhost:8080/auction-command-server/AuctionCommandService");

		// Verify user

		// Get this value from the RegisterExample console
		final String userAggregateId = "1ce5fd28-d1e5-461a-8348-62102c5781c5";

		// Get this value from Command Server console
		final String securityToken = "c97ff2874fa502e2023182f53a56cd8d8ef237ed";

		cmdService.verifyUser(userAggregateId, securityToken);

		System.out.println("User verified!");

	}

}